package unicam.IdSProject.controllers;
import unicam.IdSProject.models.PlatformHandler;
import unicam.IdSProject.models.ShoppingCart;
import unicam.IdSProject.models.QuantifiedProduct;

/**
*
* This class implements the payment methods for buying Events and Products
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*
*/
public class PurchaseHandler{

  private PlatformHandler platformHandler;
  
  public PurchaseHandler(PlatformHandler platformHandler) {
      this.platformHandler = platformHandler;
    
  }

  public boolean pay(ShoppingCart shoppingCart){
    String receipt = "Ricevuta di " + shoppingCart.getBuyer().getName() + "\n";
    for (QuantifiedProduct qProduct : shoppingCart.getQuantifiedProducts()){
      String printProduct = "Nome: " + qProduct.getProduct().getName() +
                            "\nNumero stock: " + qProduct.getStockNumber() +
                            "Prezzo: " + qProduct.getProduct().getPrice() * qProduct.getStockNumber() +"€\n\n";
      receipt = receipt + printProduct;
    }
    receipt = receipt + "Prezzo totale: " + shoppingCart.getTotalPrice() + "$";
    shoppingCart.getBuyer().getMailbox().addMessage(receipt);         // Possono andare
    platformHandler.getMailbox().addMessage(receipt);                 // bene?
    return true;
  }

  
}
