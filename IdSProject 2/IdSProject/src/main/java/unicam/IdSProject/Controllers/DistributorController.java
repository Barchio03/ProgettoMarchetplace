package unicam.IdSProject.Controllers;
import unicam.IdSProject.Models.Distributor;
import unicam.IdSProject.Models.Product;
import unicam.IdSProject.Models.ProductBoard;
import unicam.IdSProject.Models.ProductBundle;

import java.util.ArrayList;

/**
*
* This class implements the methods used by the Distributor to interact with the marketplace
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*/
public class DistributorController {

    private final Distributor distributor;
    private ProductBoard productBoard;
    private ArrayList<ProductBundle> bundlesList;

    /**
    *
    * This method creates a new DistributorController object
    */
    public DistributorController(Distributor distributor, ProductBoard productBoard, ArrayList<ProductBundle> bundlesList){
        this.distributor = distributor;
        this.productBoard = productBoard;
        this.bundlesList = bundlesList;
    }


    /**
     *
     * This method creates a new bundle with a set of product present in the marketplace
     *
     * @param products: the products present in the bundle
     *
     * @return true, if the bundle was created, false otherwise
     */
    public boolean createBundle(ArrayList<Product> products){
        if (products.isEmpty()){
            throw new IllegalArgumentException("Deve essere inserito almeno un prodotto");
        }
        for(Product product : products){
            if((product == null || !productBoard.contains(product))) {
                throw new IllegalArgumentException("Prodotti inseriti non validi");
            }
        }
        ProductBundle bundle = new ProductBundle(products, distributor.getName());
        bundlesList.add(bundle);
        return true;
    }

    /**
     *
     * This method adds a product from the marketplace inside a bundle
     *
     * @param bundle: the bundle in question
     *
     * @param product: the product that needs to be added
     *
     * @return true, if the bundle was created, false otherwise
     */
    public boolean addProductToBundle(ProductBundle bundle, Product product){
        if(product == null || !productBoard.contains(product)){
            throw new IllegalArgumentException("Prodotto inserito non valido");
        }
        if(bundle.getProducts().contains(product)){
            throw new IllegalArgumentException("Il prodotto è già presente nel bundle");
        }
        bundle.getProducts().add(product);
        return true;
    }


    /**
     *
     * This method deletes a product from a bundle
     *
     * @param bundle: the bundle in question
     *
     * @param product: the product that needs to be added
     *
     * @return true, if the product was deleted, false otherwise
     */
    public boolean deleteBundle(ProductBundle bundle, Product product) {
        if(product == null || !productBoard.contains(product)){
            throw new IllegalArgumentException("Prodotto inserito non valido");
        }
        if(!bundle.getProducts().contains(product)){
            throw new IllegalArgumentException("Il prodotto non presente nel bundle");
        }
        bundle.getProducts().remove(product);
        return true;
    }


    /**
     *
     * This method adds distributor infos to a product
     *
     * @param product: the product to witch add the information
     *
     * @param info: the info abouct the product
     *
     * @return true, if the information was added, false otherwise
     */
    public boolean addInfo(Product product, String info) {
        if(product == null || !productBoard.contains(product)){
            throw new IllegalArgumentException("Prodotto inserito non valido");
        }
        for(ProductBundle bundles : bundlesList){
            ArrayList<Product> products = bundles.getProducts();
            if (products.contains(product)){
                product.setDistributorDescription(info);
                return true;
            }
        }
        throw new IllegalArgumentException("Prodotto non presente in alcun bundle");
    }
}
