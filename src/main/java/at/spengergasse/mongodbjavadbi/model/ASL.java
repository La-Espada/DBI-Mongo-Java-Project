package at.spengergasse.mongodbjavadbi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("ASL")
public class ASL {
    @Id
    private String id;

    private String name;
}
