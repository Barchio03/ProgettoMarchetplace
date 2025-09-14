package unicam.IdSProject.Controllers;

import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import unicam.IdSProject.AcceptVisitor;
import unicam.IdSProject.DenyVisitor;
import unicam.IdSProject.RequestHandler;
import unicam.IdSProject.Visitable;

/**
 * This class represents a curator
 */
@Controller
public class Curator {

    /**
     * The visitor to approve a visitable
     */
    private AcceptVisitor acceptVisitor;

    /**
     * The request handler
     */
    private RequestHandler requestHandler;

    /**
     * The visitable to check
     */
    private Visitable toCheck;

    /**
     * Creates a new curator object
     *
     * @param acceptVisitor
     * @param requestHandler
     */
    public Curator(AcceptVisitor acceptVisitor, RequestHandler requestHandler) {
        this.acceptVisitor=acceptVisitor;
        this.requestHandler=requestHandler;
    }

    /**
     * Gets the next product to verify
     */
    @RequestMapping(value="/curator/getProduct")
    public ResponseEntity<Object> getProduct() {
        toCheck= requestHandler.getNextProduct();
        if (toCheck!=null) return new ResponseEntity<>(toCheck, HttpStatus.OK);
        else return new ResponseEntity<>("Nessun prodotto da verificare", HttpStatus.NOT_FOUND);
    }

    /**
     * Gets the next event to verify
     */
    @RequestMapping(value="/curator/getEvent")
    public ResponseEntity<Object> getEvent() {
        toCheck= requestHandler.getNextEvent();
        if (toCheck!=null) return new ResponseEntity<>(toCheck, HttpStatus.OK);
        else return new ResponseEntity<>("Nessun evento da verificare", HttpStatus.NOT_FOUND);
    }

    /**
     * Approves the visitable
     */
    @RequestMapping(value="/curator/approve")
    public ResponseEntity<Object> approve(){
        if (toCheck==null) return new ResponseEntity<>("Nessun elemento selezionato", HttpStatus.NOT_FOUND);
        toCheck.accept(acceptVisitor);
        return new ResponseEntity<>("Elemento verificato con successo", HttpStatus.OK);
    }

    /**
     * Denies the visitable
     *
     * @param message, the message to leave the creator of the visitable
     */
    @RequestMapping(value="/curator/deny")
    public ResponseEntity<Object> deny( @PathParam("message") String message){
        if (toCheck==null) return new ResponseEntity<>("Nessun elemento selezionato", HttpStatus.NOT_FOUND);
        toCheck.accept(new DenyVisitor(message));
        return new ResponseEntity<>("Elemento rifiutato con successo", HttpStatus.OK);
    }

}
