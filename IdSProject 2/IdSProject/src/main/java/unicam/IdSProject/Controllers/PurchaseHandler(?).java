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
    for (QuantifiedProduct product : shoppingCart.getProducts()){
      String product = "Nome: " +
    }
    String Receipt;
    return true;
  }

  
}
