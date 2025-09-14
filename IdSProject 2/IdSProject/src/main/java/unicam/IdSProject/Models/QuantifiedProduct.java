package unicam.IdSProject.Models;

/**
 * This class represents the product inside a shopping cart
 *
 * @author Ilaria Morettini, Luca Barchiesi, Erika Aguiari
 */
public class QuantifiedProduct {

    /**
     * The product to buy
     */
    private Product product;

    /**
     * The number of stocks to buy
     */
    private int stockNumber;

    /**
     * The total price, obtained by multiplying the stockNumber
     * with the price of the singular product
     */
    private double totalPrice;

    /**
     * Creates a new quantified product to add to a shopping cart
     *
     * @param product, the product
     * @param stockNumber, the number of stocks chosen
     */
    public QuantifiedProduct(Product product, int stockNumber) {
        this.product=product;
        this.stockNumber=stockNumber;
        this.totalPrice=product.getPrice() * stockNumber;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product, the product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the stock number
     */
    public int getStockNumber() {
        return stockNumber;
    }

    /**
     * @param stockNumber, the number of stocks chosen
     */
    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    /**
     * @return the total price
     */
    public double getTotalPrice() { return totalPrice; }

}
