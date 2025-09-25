package unicam.IdSProject.dtos.response;
import lombok.Data;
import unicam.IdSProject.models.Product;
import unicam.IdSProject.users.Seller;

@Data
public class TransformerProductDTO implements ProductDTO {

    private String name;
    private float price;
    private String description;
    private String distributorDescription;
    private int stockNumber;
    private Seller creator;
    private Product sourceProduct;

}
