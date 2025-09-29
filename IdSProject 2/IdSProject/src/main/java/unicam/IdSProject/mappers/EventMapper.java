package unicam.IdSProject.mappers;

import org.mapstruct.Mapper;
import unicam.IdSProject.dtos.requests.EventCreatedDTO;
import unicam.IdSProject.dtos.response.EventDTO;
import unicam.IdSProject.models.Event;

@Mapper(componentModel = "spring")

public interface EventMapper {
    Event toEntityWithAllFields(EventCreatedDTO dto);
    EventDTO toDtoWithAllFields(Event event);
}
