package unicam.IdSProject.Models;

import unicam.IdSProject.Visitable;
import unicam.IdSProject.Visitor;

/**
*
* This class represents a product.
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*
*/
public abstract class Product implements Visitable {

    /**
     * The name of the product
     */
    private String name;

    /**
     * The price of the product
     */
    private float price;

    /**
     * The description of the product
     */
    private String description;

    /**
     * The description added by a Distributor
     */
    private String distributorDescription;

    /**
     * The number of products available
     */
    private int stockNumber;

    /**
     * The creator of the product
     */
    private Seller creator;

    /**
     * The id of the product
     */
    private int id;

    private static int currentId;


    /**
    *
    * This method creates an object Product.
    *
    * @return an object Product.
    *
    */
    public Product() {}

    private static int getCurrentId() {
        return currentId;
    }

    /**
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * @param name, the name of the product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price of the product
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price, the price of the product
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the description of the product
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description, the description of the product
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the descrioption added by the Distributor
     */
    public String getDistributorDescription() {
        return distributorDescription;
    }

    /**
     * @param distributorDescription, the description added by the Distributor
     */
    public void setDistributorDescription(String distributorDescription) {
        this.distributorDescription = distributorDescription;
    }

    /**
     * @return the number of stock of the product
     */
    public int getStockNumber() {
        return stockNumber;
    }

    /**
     * @param stockNumber, the number of stock of the product
     */
    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    /**
     * @return the creator of the product
     */
    public Seller getCreator() {
        return creator;
    }

    /**
     * @return the id of the product
     */
    public int getId() {
        return id;
    }

    public void setCreator(Seller creator) {
        this.creator = creator;
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean equals(Object obj){

        if (obj == null){
            return false;
        }
        if(!(obj instanceof Product product)){
            return false;
        }
        else{
            return this.id == product.id;
        }
    }

}
