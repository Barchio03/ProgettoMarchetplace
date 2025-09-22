package unicam.IdSProject.dtos.requests;

import lombok.Data;
import unicam.IdSProject.users.Seller;

@Data
public class ProducerProductCreationDTO {
    private String name;
    private float price;
    private String description;
    private int stockNumber;

}
