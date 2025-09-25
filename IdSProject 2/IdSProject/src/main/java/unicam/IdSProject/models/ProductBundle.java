package unicam.IdSProject.models;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
*
* This class represents a Bundle of Products made by a Distributor
*
* @author Erika Aguiari, Luca Barchiesi
*
*/
@Entity
@Getter
@Setter
public class ProductBundle extends Product{

    @ElementCollection(targetClass = Long.class, fetch = FetchType.EAGER)
    private ArrayList<Long> products;

    /**
     * This method returns all the Sellers that made a Product that is in this Bundle.
     *
     * @return the list of Sellers.
     */
//    public ArrayList<Seller> getProductCreators() {
//        ArrayList<Seller> prodCreators = new ArrayList<>();
//        for (Product product : products){
//            if(prodCreators.contains(product.getCreator())){
//                continue;
//            }
//            prodCreators.add(product.getCreator());
//        }
//        return prodCreators;
//    }



}
