package unicam.IdSProject.Controllers;
import unicam.IdSProject.Controllers.BuyerController;
import unicam.IdSProject.Controllers.PlatformHandler;

/**
*
* This class implements the payment methods for buying Events and Products
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*
*/
public class PurchaseHandler(){

  private PlatformHandler platformHandler;
  
  public PurchaseHandler(PlatformHandler platformHandler) {
      this.platformHandler = platformHandler;
    
  }

  public boolean pay(ShoppingCart shoppingCart){
    String receipt = "";
    for (QuantifiedProduct qProduct : shoppingCart.getQuantifiedProducts()){
      String printProduct = "Nome: " + qProduct.getProduct().getName() +
                            "\nNumero stock: " + qProduct.getstockNumber() +
                            "Prezzo: " + qProduct.getProduct().getPrice() * qProduct.getStockNumber() +"€\n\n";
      receipt = receipt + printProduct;
    }
    receipt = receipt + "Prezzo totale: " + shoppingCart.getTotalPrice() + "$"
    //metodo send per inviare la ricevuta al platformHandler
    return true;
  }

  
}
