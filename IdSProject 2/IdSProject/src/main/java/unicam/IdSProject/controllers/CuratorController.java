package unicam.IdSProject.controllers;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import unicam.IdSProject.AcceptVisitor;
import unicam.IdSProject.DenyVisitor;
import unicam.IdSProject.repositories.RequestHandler;
import unicam.IdSProject.Visitable;
import unicam.IdSProject.services.CuratorService;


@Controller
@RequiredArgsConstructor
public class CuratorController {

    private final CuratorService curatorService;

    /**
     * This method gets the next Product to verify
     *
     * @return responce, the Responce Entity for the method
     */
    @RequestMapping(value="/curator/getProduct")
    public ResponseEntity<Object> getProduct() {
        return curatorService.getProduct();
    }

    /**
     * This method gets the next Event to verify
     *
     * @return responce, the Responce Entity for the method
     */
    @RequestMapping(value="/curator/getEvent")
    public ResponseEntity<Object> getEvent() {
        toCheck= requestHandler.getNextEvent();
        if (toCheck!=null) return new ResponseEntity<>(toCheck, HttpStatus.OK);
        else return new ResponseEntity<>("Nessun evento da verificare", HttpStatus.NOT_FOUND);
    }

    /**
     * This method approves the Visitable
     *
     * @return responce, the Responce Entity for the method
     */
    @RequestMapping(value="/curator/approve")
    public ResponseEntity<Object> approve(){
        if (toCheck==null) return new ResponseEntity<>("Nessun elemento selezionato", HttpStatus.NOT_FOUND);
        toCheck.accept(acceptVisitor);
        return new ResponseEntity<>("Elemento verificato con successo", HttpStatus.OK);
    }

    /**
     * This method denies the Visitable
     *
     * @return responce, the Responce Entity for the method
     */
    @RequestMapping(value="/curator/deny")
    public ResponseEntity<Object> deny( @PathParam("message") String message){
        if (toCheck==null) return new ResponseEntity<>("Nessun elemento selezionato", HttpStatus.NOT_FOUND);
        toCheck.accept(new DenyVisitor(message));
        return new ResponseEntity<>("Elemento rifiutato con successo", HttpStatus.OK);
    }

}
