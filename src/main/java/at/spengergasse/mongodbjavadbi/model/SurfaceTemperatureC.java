package at.spengergasse.mongodbjavadbi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SurfaceTemperatureC {

    private String min;
    private String max;
    private String mean;
}
