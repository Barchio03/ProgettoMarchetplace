package unicam.IdSProject.classes;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

/**
*
* This class represents a Shopping Cart
*
* @author Erika Aguiari, Luca Barchiesi
*
*/
@Getter
@Setter
@RequiredArgsConstructor
public class ShoppingCart {

//    private final String buyer;
    private final ArrayList<QuantifiedProduct> quantifiedProducts;
    private double totalPrice;

    /**
    * This method creates a new ShoppingCart object
    */
    public ShoppingCart(){
        this.quantifiedProducts = new ArrayList<>();
    }

    

    /**
     * This method adds a Product to the Shopping Cart
     *
     * @param quantifiedProduct, the Product with the number of stocks
     *
     * @return true if it was added successfully, false otherwise
     */
    public boolean addQuantifiedProduct(QuantifiedProduct quantifiedProduct) {
        if (quantifiedProduct == null) return false;
        for (QuantifiedProduct product : quantifiedProducts) {
            if (product.getProduct().equals(quantifiedProduct.getProduct())) {
                product.setStockNumber(product.getStockNumber()+quantifiedProduct.getStockNumber());
                this.calculateTotal();
                return true;
            }
        }
        quantifiedProducts.add(quantifiedProduct);
        this.calculateTotal();
        return true;
    }

    /**
     * This method removes a Product from the Shopping Cart
     *
     * @param quantifiedProduct, the Product to remove
     
     * @returntrue if it was removed successfully, false otherwise
     */
    public boolean removeQuantifiedProduct(QuantifiedProduct quantifiedProduct) {
        quantifiedProducts.remove(quantifiedProduct);
        this.calculateTotal();
        return true;
    }

    /**
     * This method clears the shopping cart
     */
    public void clear() {quantifiedProducts.clear();}


    /**
    * This method calculates the price of the whole Shopping Cart
    */
    private void calculateTotal() {
        double total = 0;
        for (QuantifiedProduct quantifiedProduct : quantifiedProducts) {
            total=total+quantifiedProduct.getTotalPrice();
        }
        this.totalPrice=total;
    }
}
