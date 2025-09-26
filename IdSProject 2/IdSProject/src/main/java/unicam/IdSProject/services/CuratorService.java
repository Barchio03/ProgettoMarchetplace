package unicam.IdSProject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import unicam.IdSProject.visitor.AcceptVisitor;
import unicam.IdSProject.visitor.DenyVisitor;
import unicam.IdSProject.visitor.Visitable;
import unicam.IdSProject.repositories.RequestHandler;

@Service
@RequiredArgsConstructor
public class CuratorService {

    private final AcceptVisitor acceptVisitor;
    private final RequestHandler requestHandler;

    private Visitable toCheck;

    public ResponseEntity<Object> getProduct() {
        toCheck= requestHandler.getNextProduct();
        if (toCheck!=null) return new ResponseEntity<>(toCheck, HttpStatus.OK);
        else return new ResponseEntity<>("Nessun prodotto da verificare", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> getEvent() {
        toCheck= requestHandler.getNextEvent();
        if (toCheck!=null) return new ResponseEntity<>(toCheck, HttpStatus.OK);
        else return new ResponseEntity<>("Nessun evento da verificare", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> accept() {
        if (toCheck==null) return new ResponseEntity<>("Nessun elemento selezionato", HttpStatus.NOT_FOUND);
        toCheck.accept(acceptVisitor);
        return new ResponseEntity<>("Elemento verificato con successo", HttpStatus.OK);
    }

    public ResponseEntity<Object> deny(String message) {
        if (toCheck==null) return new ResponseEntity<>("Nessun elemento selezionato", HttpStatus.NOT_FOUND);
        toCheck.accept(new DenyVisitor(message));
        return new ResponseEntity<>("Elemento rifiutato con successo", HttpStatus.OK);
    }

}
