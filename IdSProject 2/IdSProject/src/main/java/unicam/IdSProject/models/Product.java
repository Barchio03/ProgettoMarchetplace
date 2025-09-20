package unicam.IdSProject.models;

import unicam.IdSProject.Visitable;
import unicam.IdSProject.Visitor;

/**
*
* This class represents a Product.
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*
*/
public abstract class Product implements Visitable {

    private String name;
    private float price;
    private String description;
    private String distributorDescription;
    private int stockNumber;
    private Seller creator;
    private int id;
    private static int currentId;


    /**
    * This method creates a new Product object.
    */
    public Product() {}

    
    private static int getCurrentId() {
        return currentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDistributorDescription() {
        return distributorDescription;
    }

    public void setDistributorDescription(String distributorDescription) {
        this.distributorDescription = distributorDescription;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    public Seller getCreator() {
        return creator;
    }

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
