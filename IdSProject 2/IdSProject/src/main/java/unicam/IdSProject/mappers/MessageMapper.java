package unicam.IdSProject.mappers;


import org.mapstruct.Mapper;
import unicam.IdSProject.dtos.response.MessageDTO;
import unicam.IdSProject.models.Message;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    Message toEntityWithAllFields(MessageDTO dto);
    MessageDTO toDtoWithAllFields(Message message);
}
