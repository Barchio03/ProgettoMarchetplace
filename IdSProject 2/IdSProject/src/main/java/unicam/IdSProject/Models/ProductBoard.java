package unicam.IdSProject.Models;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

/**
*
 * This class represents a Product Board and it contains all of the Products
 *
 * @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
 *
 */
@Component
public class ProductBoard {

    private final ArrayList<Product> products;

    /**
     * This method creates a new ProductBoard object
     */
    public ProductBoard(){
        this.products = new ArrayList<Product>();
    }

    public ArrayList<Product> getProducts(){
        return products;
    }

    
    
    /**
     * This method adds a new Product to the Product Board
     *
     * @param product, the Product to add
     *
     * @return true if it is inserted successfully, false otherwise
     */
    public boolean addProduct(Product product) {
        return products.add(product);
    }

    /**
     * This method removes a Product to the Product Board
     *
     * @param product, the Product to remove
     *
     * @return true if it is removed successfully, false otherwise
     */
    public boolean removeProduct(Product product) {
        return products.remove(product);
    }

    /**
     * This method removes a Product to the Product Board given its id
     *
     * @param id, the id of the Product to remove
     *
     * @return true if it is removed successfully, false otherwise
     */
    public boolean removeProduct(int id) {
        for( Product product :  products) {
            if (product.getId() == id) {
                products.remove(product);
                return true;
            }
        }
        return false;
    }

    /**
     * This method verifies whether a Product is in the Product Board
     *
     * @param product, the Product searched for
     *
     * @return true if it is contained, false otherwise
     */
    public boolean contains(Product product) {
        return products.contains(product);
    }


    /**
     * This method returns a list of all the Products a specific Seller has published
     *
     * @param seller, the Seller from witch taking the Products
     *
     * @return  the list of Products created by the given Seller
     */
    public ArrayList<Product> getProducts(Seller seller) {
        ArrayList<Product> sublist = new ArrayList<Product>();
        for (Product product : products) {
            if (product.getCreator().equals(seller)) sublist.add(product);
        }
        return sublist;
    }

}
