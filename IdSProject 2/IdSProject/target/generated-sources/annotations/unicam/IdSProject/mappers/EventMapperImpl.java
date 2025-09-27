package unicam.IdSProject.mappers;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import unicam.IdSProject.dtos.requests.EventCreationDTO;
import unicam.IdSProject.dtos.response.EventDTO;
import unicam.IdSProject.models.Event;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-27T19:39:45+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class EventMapperImpl implements EventMapper {

    @Override
    public Event toEntityWithAllFields(EventCreationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Event event = new Event();

        event.setName( dto.getName() );
        event.setMaxAttendees( dto.getMaxAttendees() );
        event.setDescription( dto.getDescription() );

        return event;
    }

    @Override
    public EventDTO toDtoWithAllFields(Event product) {
        if ( product == null ) {
            return null;
        }

        EventDTO eventDTO = new EventDTO();

        eventDTO.setName( product.getName() );
        eventDTO.setCreator( product.getCreator() );
        eventDTO.setMaxAttendees( product.getMaxAttendees() );
        eventDTO.setDescription( product.getDescription() );
        eventDTO.setCollaborators( product.getCollaborators() );

        return eventDTO;
    }
}
