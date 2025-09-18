package unicam.IdSProject.Models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * This class represents the container for the product to sell
 *
 * @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
 */
@Component
public class ProductBoard {

    /**
     * The list of products containing all the products
     */
    private final ArrayList<Product> products;

    /**
     * Creates a new product board
     */
    public ProductBoard(){
        this.products = new ArrayList<Product>();
    }

    /**
     * Adds a new product to the product board
     *
     * @param product, the product to add
     *
     * @return true if it is inserted successfully, false otherwise
     */
    public boolean addProduct(Product product) {
        return products.add(product);
    }

    /**
     * Removes a product to the product board
     *
     * @param product, the product to remove
     *
     * @return true if it is removed successfully, false otherwise
     */
    public boolean removeProduct(Product product) {
        return products.remove(product);
    }

    /**
     * Removes a product to the product board
     *
     * @param id, the id of the product to remove
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
     * Verifies whether a product is in the product board
     *
     * @param product, the product searched for
     *
     * @return true if the product is contained, false otherwise
     */
    public boolean contains(Product product) {
        return products.contains(product);
    }

    public ArrayList<Product> getProducts(){
        return products;
    }

    /**
     * Returns a list of all the products a specific seller has published
     *
     * @param seller, the seller from witch taking the products
     *
     * @return an ArrayList of products created by the seller given
     */
    public ArrayList<Product> getProducts(Seller seller) {
        ArrayList<Product> sublist = new ArrayList<Product>();
        for (Product product : products) {
            if (product.getCreator().equals(seller)) sublist.add(product);
        }
        return sublist;
    }

}
