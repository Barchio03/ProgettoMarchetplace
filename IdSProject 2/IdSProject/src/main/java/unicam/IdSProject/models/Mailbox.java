package unicam.IdSProject.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Tolerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import unicam.IdSProject.dtos.response.MessageDTO;
import unicam.IdSProject.mappers.MessageMapper;
import unicam.IdSProject.repositories.MessageRepository;

import java.util.ArrayList;

/**
*
* This class represents the Mailbox where users receive messages
*
* @author Aguiari Erika, Barchiesi Luca
*
*/
@RequiredArgsConstructor
@Component
public class Mailbox {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    /**
     * This method adds a message into the Mailbox
     *
     * @param message, the message to add
     */
    public void addMessage(String owner, String message) {
        messageRepository.save(new Message(null, owner, message));
    }

    /**
     * This method returns all the messages inside the Mailbox
     *
     * @return the messages inside the Mailbox
     */
    public ArrayList<MessageDTO> getMessages(String owner) {
        ArrayList<Message> messages = (ArrayList<Message>) messageRepository.findAllByReceiver(owner);
        ArrayList<MessageDTO> dtos = new ArrayList<>();
        for (Message message : messages) {
            dtos.add(messageMapper.toDtoWithAllFields(message));
        }
        return dtos;
    }

    /**
     * This method deletes all the messages inside the Mailbox
     */
    public void refresh(String owner) {
        ArrayList<Message> messages = (ArrayList<Message>) messageRepository.findAllByReceiver(owner);
        ArrayList<Long> ids = (ArrayList<Long>) messages.stream().map(Message::getId).toList();
        messageRepository.deleteAllById(ids);
    }
}
