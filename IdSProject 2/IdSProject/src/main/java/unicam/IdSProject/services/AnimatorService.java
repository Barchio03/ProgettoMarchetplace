package unicam.IdSProject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import unicam.IdSProject.dtos.requests.EventCreatedDTO;
import unicam.IdSProject.mappers.EventMapper;
import unicam.IdSProject.models.Event;
import unicam.IdSProject.models.Mailbox;
import unicam.IdSProject.models.Message;
import unicam.IdSProject.models.Subscriber;
import unicam.IdSProject.repositories.EventBoard;
import unicam.IdSProject.repositories.MessageRepository;
import unicam.IdSProject.repositories.RequestHandler;
import unicam.IdSProject.repositories.SubscriberRepository;
import unicam.IdSProject.users.Animator;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AnimatorService {

    private final RequestHandler requestHandler;

    private final Mailbox mailbox;

    private final EventMapper eventMapper;

    private final EventBoard eventBoard;
    private final SubscriberRepository subscriberRepository;
    private final MessageRepository messageRepository;

    private Animator animator = new Animator("anim1", "Animator", "Just an animator");


    public ResponseEntity<Object> addEvent(EventCreatedDTO eventDTO){
        Event event = eventMapper.toEntityWithAllFields(eventDTO);
        event.setCreator(animator.getId());
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
            notifySubscribers(id, "Evento cancellato");
            subscriberRepository.deleteAll( subscriberRepository.findAllByEventId(id));
            return new ResponseEntity<>("Evento rimosso con successo", HttpStatus.OK);
        }
        return new ResponseEntity<>("Id non pervenuto", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> openMailbox() {
        return new ResponseEntity<>(mailbox.getMessages(animator.getId()), HttpStatus.OK) ;
    }

    /**
     * This method notifies the subscribers when needed
     *
     * @param message, the message to spread
     */
    private void notifySubscribers(Long id, String message) {
        for (Subscriber sub : subscriberRepository.findAllByEventId(id)) {
            messageRepository.save(new Message(null, sub.getBuyerId(), message));
        }
    }

}
