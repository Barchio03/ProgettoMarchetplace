package unicam.IdSProject.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Tolerate;
import org.springframework.beans.factory.annotation.Autowired;
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
public class Mailbox {

    private static MessageRepository messageRepository;

    /**
     * This method adds a message into the Mailbox
     *
     * @param message, the message to add
     */
    public static void addMessage(String owner, String message) {
        messageRepository.save(new Message(null, owner, message));
    }

    /**
     * This method returns all the messages inside the Mailbox
     *
     * @return the messages inside the Mailbox
     */
    public static ArrayList<String> getMessages(String owner) {
        ArrayList<Message> messages = (ArrayList<Message>) messageRepository.findByReceiver(owner);
        return (ArrayList<String>) messages.stream().map(Message::getMessage).toList();
    }

    /**
     * This method deletes all the messages inside the Mailbox
     */
    public void refresh(String owner) {
        ArrayList<Message> messages = (ArrayList<Message>) messageRepository.findByReceiver(owner);
        ArrayList<Long> ids = (ArrayList<Long>) messages.stream().map(Message::getId).toList();
        messageRepository.deleteAllById(ids);
    }
}
