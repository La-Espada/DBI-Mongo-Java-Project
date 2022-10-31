package at.spengergasse.mongodbjavadbi;

import at.spengergasse.mongodbjavadbi.model.ASL;
import at.spengergasse.mongodbjavadbi.model.Planet;
import at.spengergasse.mongodbjavadbi.repository.ASLRepository;
import at.spengergasse.mongodbjavadbi.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class MongoDbJavaDbiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MongoDbJavaDbiApplication.class, args);
    }

    @Autowired
    ASLRepository aslRepository ;
    //PlanetRepository planetRepository;

    @Bean
    CommandLineRunner runner(PlanetRepository planetRepository){
        return args ->{

            System.out.println("\n" +
                    "//(2) Collections & CRUD-Operations\n" +
                    "//a) Lege eine Collection mit deinem Namenskürzel an");
            ASL asl = new ASL("Cemil Aslan");
            aslRepository.insert(asl);
            System.out.println("b) Lies eine Collection aus, die bereits auf deinem MongoServer eingespielt ist, zB Pokemon,\n" +
                    "//Achtung: diese Collection liegt (ziemlich sicher) nicht in derselben mongo-database wie die zuvor erstellte Collection\n" +
                    "// Ermittle, wie viele Dokumente in dieser Collection liegen");
            getAllPlanets(planetRepository);

            System.out.println("c)  Liste die Dokumente aus dieser Collection auf. Zeige allerdings nur das \"Bezeichner\"-Feld (also zB Name)");
            getPlanetsByName(planetRepository);
            System.out.println("Ändere nun die Projektion, sodass nur der Bezeichner angezeigt wird (also zB der Name).");
            getPlanetsByName(planetRepository);
            System.out.println("e) finden von bestimmten Datensätzen");
            getPlanetBymainAtmosphere(planetRepository, "-139.15");
            System.out.println("f) finde den Mittelwert des Planeten Erde und aktualisiere ihn um 2 grad");
            updatePlanet(planetRepository,"Earth",2);
        };


    }

    public void getAllPlanets(PlanetRepository planetRepository){
        List<Planet> planets = planetRepository.findAll();

        for (Planet planet: planets) {
           outputPlanet(planet);
        }
        System.out.println("Count of documents: "+planets.size());
    }

    public String outputMainAtmosphere(Planet planet){
        System.out.println("\nmainAtmosphere: ");
        for(int i = 0; i < planet.getMainAtmosphere().length; i++){
            System.out.println(planet.getMainAtmosphere()[i]);
        }
        return"outputMainAtmosphere";
    }

    public void getPlanetsByName(PlanetRepository planetRepository){
        List<Planet> planets = planetRepository.findAll();
        planets.forEach(planet -> System.out.println("Name: " + planet.getName()));
    }

    public void getPlanetBymainAtmosphere(PlanetRepository planetRepository,String mean){
        List<Planet> planets = planetRepository.findAll();
        Planet planete = null;

        for(Planet planet : planets){
            if(planet.getSurfaceTemperatureC().getMean().equals(mean)){
                planete = planet;
                outputPlanet(planet);
            }
        }

        if(planete == null){
            System.out.println("Seems like there is no  planet with this mean.");
        }


    }

    public void updatePlanet(PlanetRepository planetRepository, String name, int add){
        Planet planet = planetRepository.findByName(name);
        outputPlanet(planet);
        int mean = Integer.parseInt(planet.getSurfaceTemperatureC().getMean()) + add;
        planet.getSurfaceTemperatureC().setMean(String.valueOf(mean));
        outputPlanet(planet);
        planetRepository.save(planet);
    }

    public void outputPlanet(Planet planet){
        System.out.println("\n" + "id: " + planet.getId() +
                "\nName: " +planet.getName() +
                "\norderFromSum: " + planet.getOrderFromSun() +
                "\nhasRings: " + planet.isHasRings() +
                "\nsurfaceTemperatureC: " +
                "\nmin: " + planet.getSurfaceTemperatureC().getMin() +
                "\nmax: " + planet.getSurfaceTemperatureC().getMax() +
                "\nmean: " + planet.getSurfaceTemperatureC().getMean());
        outputMainAtmosphere(planet);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
