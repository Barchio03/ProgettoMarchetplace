package unicam.IdSProject.dtos;

import unicam.IdSProject.models.Seller;

public class ProductDTO {

    private String name;
    private float price;
    private String description;
    private String distributorDescription;
    private int stockNumber;
    private Seller creator;

    public ProductDTO( String name, float price, String description, String distributorDescription, int stockNumber, Seller creator){
        this.name = name;
        this.price = price;
        this.description = description;
        this.distributorDescription = distributorDescription;
        this.stockNumber = stockNumber;
        this.creator = creator;
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

    public void setCreator(Seller creator) {
        this.creator = creator;
    }
}
