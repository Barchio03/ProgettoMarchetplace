package unicam.IdSProject.dtos;
import lombok.Data;
import unicam.IdSProject.models.Seller;

@Data
public class ProducerProductDTO implements ProductDTO {

    private String name;
    private float price;
    private String description;
    private String distributorDescription;
    private int stockNumber;
    private Seller creator;

}