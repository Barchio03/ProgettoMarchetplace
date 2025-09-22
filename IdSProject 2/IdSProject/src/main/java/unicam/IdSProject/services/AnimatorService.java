package unicam.IdSProject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import unicam.IdSProject.dtos.requests.EventCreationDTO;
import unicam.IdSProject.dtos.response.EventDTO;
import unicam.IdSProject.mappers.EventMapper;
import unicam.IdSProject.models.Event;
import unicam.IdSProject.repositories.EventBoard;
import unicam.IdSProject.repositories.RequestHandler;
import unicam.IdSProject.users.Animator;

@Service
@RequiredArgsConstructor
public class AnimatorService {

    private final RequestHandler requestHandler;

    private final EventMapper eventMapper;

    private final EventBoard eventBoard;

    private final Animator animator;


    public ResponseEntity<Object> addEvent(EventCreationDTO eventDTO){
        Event event = eventMapper.toEntityWithAllFields(eventDTO);
        event.setCreator(animator);

        event.setCreator(animator);
        if(!eventBoard.contains(event)){
            if (requestHandler.addEvent(event)) {
                return new ResponseEntity<>("Evento in processo di verifica", HttpStatus.CREATED);
            }
            return new ResponseEntity<>("Richiesta già in atto", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("L'evento esiste già", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> removeEvent(Long id) {
        if (eventBoard.removeEvent(id)) {
            return new ResponseEntity<>("Evento rimosso con successo", HttpStatus.OK);
        }
        return new ResponseEntity<>("Id non pervenuto", HttpStatus.NOT_FOUND);
    }

}
