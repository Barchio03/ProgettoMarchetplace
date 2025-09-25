package unicam.IdSProject.dtos.requests;

import lombok.Data;
import unicam.IdSProject.models.Product;

@Data
public class TransformerProductCreationDTO {

    private String name;
    private float price;
    private String description;
    private int stockNumber;
    private Product sourceProduct;

}
