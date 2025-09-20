package unicam.IdSProject.models;
import java.util.ArrayList;

/**
*
* This class represents a Bundle of Products made by a Distributor
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*
*/
public class ProductBundle extends Product{

    private ArrayList<Product> products;

    /**
    * This method creates a new ProductBundle object
    */
    public ProductBundle(ArrayList<Product> products, String creator) {
        this.products = products;
    }


    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {

        this.products = products;
    }




    /**
     * This method returns all the Sellers that made a Product that is in this Bundle.
     *
     * @return the list of Sellers.
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
