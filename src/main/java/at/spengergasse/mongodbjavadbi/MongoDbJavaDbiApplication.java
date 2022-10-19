package at.spengergasse.mongodbjavadbi;

import at.spengergasse.mongodbjavadbi.model.ASL;
import at.spengergasse.mongodbjavadbi.repository.ASLRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongoDbJavaDbiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MongoDbJavaDbiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }

    @Bean
    CommandLineRunner runner(ASLRepository aslRepository){
        return args -> {
            ASL asl = new ASL("Cemil");

            aslRepository.insert(asl);
        };
    }
}
