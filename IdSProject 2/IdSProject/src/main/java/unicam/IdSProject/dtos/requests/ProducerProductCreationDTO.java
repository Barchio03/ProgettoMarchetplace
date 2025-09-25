package unicam.IdSProject.dtos.requests;

import lombok.Data;

@Data
public class ProducerProductCreationDTO {
    private String name;
    private float price;
    private String description;
    private int stockNumber;

}
