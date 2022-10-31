package at.spengergasse.mongodbjavadbi.repository;

import at.spengergasse.mongodbjavadbi.model.ASL;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ASLRepository extends MongoRepository<ASL,String> {
}
