package unicam.IdSProject.controllers;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import unicam.IdSProject.repositories.EventBoard;
import unicam.IdSProject.models.Animator;
import unicam.IdSProject.models.Event;
import unicam.IdSProject.repositories.RequestHandler;

/**
*
* This class implements the methods for handling all the Animator interaction with the marketplace
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*
*/
public class AnimatorController {

    @Autowired
    private RequestHandler requestHandler;
    @Autowired
    private EventBoard eventBoard;

    private final Animator animator;

    public AnimatorController(Animator animator){
        this.animator = animator;
    }



    /**
     * This method is used to create a new event
     *
     * @param event , the body of the event that needs to be created
     *
     * @return ResponseEntity<Object>, the response about the procedure
     */
    @RequestMapping(value = "/animator/addEvent")
    public ResponseEntity<Object> addEvent(@RequestBody Event event){
        event.setCreator(animator);
        if(!eventBoard.contains(event)){
            if (requestHandler.addEvent(event)) {
                return new ResponseEntity<>("Evento in processo di verifica", HttpStatus.CREATED);
            }
            return new ResponseEntity<>("Richiesta già in atto", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("L'evento esiste già", HttpStatus.BAD_REQUEST);


    }

    /**
     * This method is used to create a new event
     *
     * @param id , the id of the event that needs to be deleted
     *
     * @return ResponseEntity<Object>, the response about the procedure
     */
    @RequestMapping(value = "/animator/removeEvent")
    public ResponseEntity<Object> removeEvent(@PathParam("id") int id) {
        if (eventBoard.removeEvent(id)) {
            return new ResponseEntity<>("Evento rimosso con successo", HttpStatus.OK);
        }
        return new ResponseEntity<>("Id non pervenuto", HttpStatus.NOT_FOUND);
    }
}
