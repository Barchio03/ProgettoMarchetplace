package unicam.IdSProject;

import unicam.IdSProject.Models.Event;

public class DenyVisitor implements Visitor {

    private String message;

    public DenyVisitor(String message) {
        this.message=message;
    }

    @Override
    public void visit(Product product) {
        product.getCreator().getMailbox().addMessage("La tua richiesta per il prodotto "+
                product.getName()+ " è stata negata. \nMotivo: "+message);
    }

    @Override
    public void visit(Event event) {
        event.getCreator().getMailbox().addMessage("La tua richiesta per l'evento "+
                event.getName()+ " è stata negata. \nMotivo: "+message);
    }
}
