package unicam.IdSProject;

import unicam.IdSProject.Models.Event;
import unicam.IdSProject.Models.Product;

public class OpenVisitor implements Visitor {

    private RequestHandler requestHandler;

    @Override
    public void visit(Product product) {
        product.toString();
    }

    @Override
    public void visit(Event event) {
        event.toString();
    }
}
