package unicam.IdSProject;

import java.util.ArrayList;

/**
 * This class represents a shopping cart
 *
 * @author Luca Barchiesi, Erika Aguiari, Ilaria Morettini
 */
public class ShoppingCart {

    /**
     * The list of quantified products
     */
    private ArrayList<QuantifiedProduct> quantifiedProducts;

    /**
     * the total price of the shopping cart
     */
    private double totalPrice;

    public ShoppingCart(){
        this.quantifiedProducts = new ArrayList<>();
    }

    /**
     * Adds a product to the shopping cart
     *
     * @param quantifiedProduct, the product
     *
     * @return true if it was added successfully, false otherwise
     */
    public boolean addQuantifiedProduct(QuantifiedProduct quantifiedProduct) {
        if (quantifiedProduct == null) return false;
        for (QuantifiedProduct product : quantifiedProducts) {
            if (product.getProduct().equals(quantifiedProduct.getProduct())) {
                product.setStockNumber(product.getStockNumber()+quantifiedProduct.getStockNumber());
                return true;
            }
        }
        quantifiedProducts.add(quantifiedProduct);
        this.calculateTotal();
        return true;
    }

    /**
     * Removes a product from the shopping cart
     *
     * @param quantifiedProduct
     * @returntrue if it was removed successfully, false otherwise
     */
    public boolean removeQuantifiedProduct(QuantifiedProduct quantifiedProduct) {
        quantifiedProducts.remove(quantifiedProduct);
        this.calculateTotal();
        return true;
    }

    /**
     * @return the total price
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    //private void setTotalPrice(float totalPrice) { this.totalPrice = totalPrice; }

    /**
     * @return the list of quantified products
     */
    public ArrayList<QuantifiedProduct> getQuantifiedProducts() {
        return quantifiedProducts;
    }

    /**
     * Calculates the total price
     */
    private void calculateTotal() {
        double total = 0;
        for (QuantifiedProduct quantifiedProduct : quantifiedProducts) {
            total*=quantifiedProduct.getTotalPrice();
        }
        this.totalPrice=total;
    }
}
