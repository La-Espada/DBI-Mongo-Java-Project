package at.spengergasse.mongodbjavadbi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter


@Document("ASL")
public class ASL {
    @Id
    private String id;

    private String name;

    public ASL(String nameE){
        name = nameE;
    }
}
