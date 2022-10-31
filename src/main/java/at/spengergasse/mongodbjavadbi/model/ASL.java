package at.spengergasse.mongodbjavadbi.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@RequiredArgsConstructor


@Data
@Document("ASL")
public class ASL {
    @Id
    private String id;

    private String name;


    public ASL (String Name){
        name = Name;
    }

}
