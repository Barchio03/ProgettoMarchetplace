package unicam.IdSProject.dtos;
import lombok.Data;
import unicam.IdSProject.models.Product;
import unicam.IdSProject.users.Seller;

@Data
public class TrasformerProductDTO implements ProductDTO {

    private String name;
    private float price;
    private String description;
    private String distributorDescription;
    private int stockNumber;
    private Seller creator;
    private Product sourceProduct;

}
