package unicam.IdSProject.Controllers;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import unicam.IdSProject.Models.EventBoard;
import unicam.IdSProject.Models.Animator;
import unicam.IdSProject.Models.Event;
import unicam.IdSProject.Models.RequestHandler;

public class AnimatorController {

    @Autowired
    private RequestHandler requestHandler;
    @Autowired
    private EventBoard eventBoard;

    private Animator animator;

    public AnimatorController(Animator animator){
        this.animator = animator;
    }

    /**
     * This method is used to create a new event
     *
     * @return true if the event creation was successful, else otherwise
     */
    public boolean createEvent() {
        return false;
    }

    /**
     *
     * This method is used to remove an event from the marketplace.
     *
     * @return true if the event is removed successfully, false otherwise.
     *
     */
    public boolean deleteEvent(Event event) {
        return false;
    }



    @RequestMapping(value = "/animator/addEvent")
    public ResponseEntity<Object> addEvent(@RequestBody Event event){
        event.setCreator(animator);
        if(!eventBoard.contains(event)){
            if (requestHandler.addEvent(event)) {
                return new ResponseEntity<>("Evento in processo di verifica", HttpStatus.CREATED);
            }
            return new ResponseEntity<>("Richiesta già in atto", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("L\'evento esiste già", HttpStatus.BAD_REQUEST);


    }


    @RequestMapping(value = "/animator/removeEvent")
    public ResponseEntity<Object> removeEvent(@PathParam("id") int id) {
        if (eventBoard.removeEvent(id)) {
            return new ResponseEntity<>("Evento rimosso con successo", HttpStatus.OK);
        }
        return new ResponseEntity<>("Id non pervenuto", HttpStatus.NOT_FOUND);
    }
}
