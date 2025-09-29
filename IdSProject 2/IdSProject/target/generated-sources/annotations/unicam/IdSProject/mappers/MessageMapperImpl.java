package unicam.IdSProject.mappers;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import unicam.IdSProject.dtos.response.MessageDTO;
import unicam.IdSProject.models.Message;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-29T10:24:40+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class MessageMapperImpl implements MessageMapper {

    @Override
    public Message toEntityWithAllFields(MessageDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Message message = new Message();

        message.setMessage( dto.getMessage() );

        return message;
    }

    @Override
    public MessageDTO toDtoWithAllFields(Message message) {
        if ( message == null ) {
            return null;
        }

        MessageDTO messageDTO = new MessageDTO();

        messageDTO.setMessage( message.getMessage() );

        return messageDTO;
    }
}
