package unicam.IdSProject.mappers;

import org.mapstruct.Mapper;
import unicam.IdSProject.dtos.EventDTO;
import unicam.IdSProject.models.Event;

@Mapper(componentModel = "spring")
public interface EventMapper {
    Event toEntityWithAllFields(EventDTO dto);
    EventDTO toDtoWithAllFields(Event product);
}