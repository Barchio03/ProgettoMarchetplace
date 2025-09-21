package unicam.IdSProject.controllers;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import unicam.IdSProject.dtos.EventDTO;
import unicam.IdSProject.repositories.EventBoard;
import unicam.IdSProject.services.AnimatorService;
import unicam.IdSProject.users.Animator;
import unicam.IdSProject.repositories.RequestHandler;

/**
*
* This class implements the methods for handling all the Animator interaction with the marketplace
*
* @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
*
*/

@Controller
@RequiredArgsConstructor
public class AnimatorController {

    private final AnimatorService animatorService;

    /**
     * This method is used to create a new event
     *
     * @param event , the body of the event that needs to be created
     *
     * @return ResponseEntity<Object>, the response about the procedure
     */
    @RequestMapping(value = "/animator/addEvent")
    public ResponseEntity<Object> addEvent(@RequestBody EventDTO event){
        return animatorService.addEvent(event);
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
        return animatorService.removeEvent(id);
    }
}
