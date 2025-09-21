package unicam.IdSProject.models;

import unicam.IdSProject.users.Seller;

/**
 * This class represents a Product made by a Producer
 *
 * @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
 *
 */
public class ProducerProduct extends Product {


    /**
     * This method creates a new Product object.
     *
     * @param name , the name of the Product
     * @param price , the price of the Product
     * @param description , the description of the Product
     * @param stockNumber , the amount of Product's stocks
     * @param creator , the Seller who created the Product
     *
     */
    public ProducerProduct(String name, float price, String description, int stockNumber, Seller creator) {
        super(name, price, description, stockNumber, creator);
    }
}
