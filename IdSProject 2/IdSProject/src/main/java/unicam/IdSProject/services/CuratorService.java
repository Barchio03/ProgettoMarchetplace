package unicam.IdSProject.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import unicam.IdSProject.AcceptVisitor;
import unicam.IdSProject.Visitable;
import unicam.IdSProject.repositories.RequestHandler;

public class CuratorService {

    private final AcceptVisitor acceptVisitor;
    private final RequestHandler requestHandler;
    private Visitable toCheck;

    public ResponseEntity<Object> getProduct() {
        toCheck= requestHandler.getNextProduct();
        if (toCheck!=null) return new ResponseEntity<>(toCheck, HttpStatus.OK);
        else return new ResponseEntity<>("Nessun prodotto da verificare", HttpStatus.NOT_FOUND);
    }

}
