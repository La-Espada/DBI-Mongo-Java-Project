package at.spengergasse.mongodbjavadbi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("pokemon")
public class Pokemon {

    @Id
    private String Id;
    private int num;
    private String img;
    private String[] type;
    private double height;
    private double weight;
    private int egg;
    private Candy candy;
    private Spawn spawn;
    private double[] multipliers;
    private String[] weaknesses;
    private Pokemon[] next_evolution;
}
