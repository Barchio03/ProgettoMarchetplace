package unicam.IdSProject.services;

import org.springframework.http.ResponseEntity;
import unicam.IdSProject.models.QuantifiedProduct;

public class BuyerService {


    public ResponseEntity<Object> addProductToShoppingKart(Product product, int quantity) {

        QuantifiedProduct qProduct = new QuantifiedProduct(product, quantity);
        return buyer.getShoppingCart().addQuantifiedProduct(qProduct);

    }

}
