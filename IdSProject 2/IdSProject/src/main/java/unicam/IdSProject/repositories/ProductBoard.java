package unicam.IdSProject.repositories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import unicam.IdSProject.models.Product;
import unicam.IdSProject.users.Seller;

import java.util.ArrayList;

/**
*
 * This class represents a Product Board, it contains all the Products
 *
 * @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
 *
 */
@Component
@AllArgsConstructor
public class ProductBoard {

    private final ProductRepository productRepository;

    /**
     * This method returns a list of all the Product in the repository
     *
     * @return a list of all the Product in the repository
     */
    public ArrayList<Product> getProducts(){
        return (ArrayList<Product>) productRepository.findAll();
    }
    
    
    /**
     * This method adds a new Product to the Product Board
     *
     * @param product, the Product to add
     *
     * @return true if it is inserted successfully, false otherwise
     */
    public boolean addProduct(Product product) {
        productRepository.save(product);
        return true;
    }

    /**
     * This method removes a Product to the Product Board
     *
     * @param product, the Product to remove
     *
     * @return true if it is removed successfully, false otherwise
     */
    public boolean removeProduct(Product product) {
        productRepository.delete(product);
        return true;
    }

    /**
     * This method removes a Product to the Product Board given its id
     *
     * @param id, the id of the Product to remove
     *
     * @return true if it is removed successfully, false otherwise
     */
    public boolean removeProduct(long id) {
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            return true;
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
        return productRepository.existsById(product.getId());
    }


    /**
     * This method returns a list of all the Products a specific Seller has published
     *
     * @param seller, the Seller from witch taking the Products
     *
     * @return  the list of Products created by the given Seller
     */
    public ArrayList<Product> getProducts(Seller seller) {
        ArrayList<Product> sublist = new ArrayList<>();
        ArrayList<Product> products = (ArrayList<Product>) productRepository.findAll();
        for (Product product : products) {
            if (product.getCreator().equals(seller)) sublist.add(product);
        }
        return sublist;
    }

}
