package at.spengergasse.mongodbjavadbi.repository;

import at.spengergasse.mongodbjavadbi.model.Planet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlanetRepository extends MongoRepository<Planet,String>{

    public Planet findByName(String name);
}
