package unicam.IdSProject.controllers;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import unicam.IdSProject.dtos.requests.EventCreatedDTO;
import unicam.IdSProject.services.AnimatorService;

/**
*
* This class implements the methods for handling all the Animator interaction with the marketplace
*
* @author Erika Aguiari, Luca Barchiesi
*
*/

@Controller
@RequiredArgsConstructor
@RequestMapping(value="/animator")
public class AnimatorController {

    private final AnimatorService animatorService;

    /**
     * This method is used to create a new event
     *
     * @param event , the body of the event that needs to be created
     *
     * @return ResponseEntity<Object>, the response about the procedure
     */
    @PostMapping(value = "/addEvent")
    public ResponseEntity<Object> addEvent(@RequestBody EventCreatedDTO event){
        return animatorService.addEvent(event);
    }

    /**
     * This method is used to create a new event
     *
     * @param id , the id of the event that needs to be deleted
     *
     * @return ResponseEntity<Object>, the response about the procedure
     */
    @DeleteMapping(value = "/removeEvent")
    public ResponseEntity<Object> removeEvent(@PathParam("id") Long id) {
        return animatorService.removeEvent(id);
    }
}
