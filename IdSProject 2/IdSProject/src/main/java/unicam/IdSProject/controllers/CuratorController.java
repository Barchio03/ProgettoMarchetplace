package unicam.IdSProject.controllers;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import unicam.IdSProject.services.CuratorService;

/**
 *
 * This class implements the methods used by the Curator to interact with the marketplace
 *
 * @author Erika Aguiari, Luca Barchiesi
 *
 */
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/curator")
public class CuratorController {

    private final CuratorService curatorService;

    /**
     * This method gets the next Product to verify
     *
     * @return the response Entity for the method
     */
    @GetMapping(value="/getProduct")
    public ResponseEntity<Object> getProduct() {
        return curatorService.getProduct();
    }

    /**
     * This method gets the next Event to verify
     *
     * @return the response Entity for the method
     */
    @GetMapping(value="/getEvent")
    public ResponseEntity<Object> getEvent() {
        return curatorService.getEvent();
    }

    /**
     * This method approves the Visitable
     *
     * @return the response Entity for the method
     */
    @PostMapping(value="/approve")
    public ResponseEntity<Object> approve(){
        return curatorService.accept();
    }

    /**
     * This method denies the Visitable
     *
     * @return the response Entity for the method
     */
    @DeleteMapping(value="/deny")
    public ResponseEntity<Object> deny( @PathParam("message") String message){
        return curatorService.deny(message);
    }

}
