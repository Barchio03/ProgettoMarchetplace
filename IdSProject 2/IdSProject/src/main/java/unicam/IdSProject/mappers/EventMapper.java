package unicam.IdSProject.mappers;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import unicam.IdSProject.dtos.requests.EventCreationDTO;
import unicam.IdSProject.dtos.response.EventDTO;
import unicam.IdSProject.models.Event;

@Mapper(componentModel = "spring")

public interface EventMapper {
    Event toEntityWithAllFields(EventCreationDTO dto);
    EventDTO toDtoWithAllFields(Event product);
}
