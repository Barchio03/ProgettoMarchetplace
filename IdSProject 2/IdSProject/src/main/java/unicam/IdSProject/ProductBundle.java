package unicam.IdSProject;

import unicam.IdSProject.Models.Product;
import unicam.IdSProject.Models.Seller;

import java.util.ArrayList;

/**
 * This class represents a bundle of products that is made by a distributor
 */
public class ProductBundle {

    private ArrayList<Product> products;

    private final String creator;

    public ProductBundle(ArrayList<Product> products, String creator) {
        this.products = products;
        this.creator = creator;
    }


    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {

        this.products = products;
    }

    public String getCreator() {
        return creator;
    }



    /**
     * This method returns all the sellers that made a product that is in this bundle.
     *
     * @return the list of sellers.
     */
    public ArrayList<Seller> getProductCreators() {
        ArrayList<Seller> prodCreators = new ArrayList<>();
        for (Product product : products){
            if(prodCreators.contains(product.getCreator())){
                continue;
            }
            prodCreators.add(product.getCreator());
        }
        return prodCreators;
    }



}
