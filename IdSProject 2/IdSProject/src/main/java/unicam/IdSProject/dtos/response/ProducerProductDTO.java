package unicam.IdSProject.dtos.response;
import lombok.Data;
import unicam.IdSProject.users.Seller;

@Data
public class ProducerProductDTO implements ProductDTO {

    private String name;
    private float price;
    private String description;
    private String distributorDescription;
    private int stockNumber;
    private SellerDTO creator;

}
