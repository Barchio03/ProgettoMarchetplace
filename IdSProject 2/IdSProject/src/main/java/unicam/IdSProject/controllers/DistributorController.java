package unicam.IdSProject.controllers;
import unicam.IdSProject.users.Distributor;
import unicam.IdSProject.models.Product;
import unicam.IdSProject.repositories.ProductBoard;
import unicam.IdSProject.models.ProductBundle;
import java.util.ArrayList;

/**
*
* This class implements the methods used by the Distributor to interact with the marketplace
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
 *
*/
public class DistributorController {

    private final Distributor distributor;
    private ProductBoard productBoard;

    /**
    *
    * This method creates a new DistributorController object
    */
    public DistributorController(Distributor distributor, ProductBoard productBoard){
        this.distributor = distributor;
        this.productBoard = productBoard;
    }


    /**
     *
     * This method creates a new Bundle with a set of Product present in the marketplace
     *
     * @param products: the Products present in the Bundle
     *
     * @return true, if the Bundle was created, false otherwise
     */
    public boolean createBundle(ArrayList<Product> products){
        if (products.isEmpty()){
            return false;
        }
        for(Product product : products){
            if((product == null || !productBoard.contains(product))) {
               return false;
            }
        }
        ProductBundle bundle = new ProductBundle(products, distributor.getName());
        return true;
    }



    /**
     *
     * This method adds a Product from the marketplace inside a Bundle
     *
     * @param bundle: the Bundle in question
     *
     * @param product: the Product that needs to be added
     *
     * @return true, if the Bundle was created, false otherwise
     */
    public boolean addProductToBundle(ProductBundle bundle, Product product){
        if(product == null || !productBoard.contains(product)){
            return false;
        }
        if(bundle.getProducts().contains(product)){
            return false;
        }
        bundle.getProducts().add(product);
        return true;
    }



    /**
     *
     * This method deletes a Bundle from the marketplace
     *
     * @param bundle: the Bundle in question
     *
     * @return true, if the Product was deleted, false otherwise
     */
    public boolean deleteBundle(ProductBundle bundle) {
        if(bundle == null || !productBoard.contains(bundle)){
            return false;
        }
        productBoard.removeProduct(bundle);
        return true;
    }


    /**
     *
     * This method adds Distributor infos to a Product
     *
     * @param product: the Product to witch add the information
     *
     * @param info: the info about the Product
     *
     * @return true, if the information was added, false otherwise
     */
    public boolean addInfo(Product product, String info) {
        if (product == null || !productBoard.contains(product)) {
            return false;
        }
        if (info == null || info.isEmpty()){
            return false;
        }
        product.setDistributorDescription(info);
        return true;
    }
}