package at.spengergasse.mongodbjavadbi.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Getter
@Setter

@Data
@Document("Planet")
public class Planet {
    @Id
    private String id;
    private String name;
    private int orderFromSun;
    private boolean hasRings;
    private String[] mainAtmosphere;
    private SurfaceTemperatureC surfaceTemperatureC;


}
