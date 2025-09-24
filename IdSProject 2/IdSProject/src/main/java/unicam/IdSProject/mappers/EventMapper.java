package unicam.IdSProject.mappers;

import org.mapstruct.Mapper;
import unicam.IdSProject.dtos.requests.EventBoughtDTO;
import unicam.IdSProject.dtos.requests.EventCreationDTO;
import unicam.IdSProject.dtos.response.EventDTO;
import unicam.IdSProject.models.Event;

@Mapper(componentModel = "spring")
public interface EventMapper {
    Event toEntityWithAllFields(EventCreationDTO dto);
    Event toEntityWithAllFields(EventBoughtDTO dto);
    EventDTO toDtoWithAllFields(Event product);
}