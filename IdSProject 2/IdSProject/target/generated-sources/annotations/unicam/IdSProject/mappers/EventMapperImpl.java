package unicam.IdSProject.mappers;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import unicam.IdSProject.dtos.requests.EventCreatedDTO;
import unicam.IdSProject.dtos.response.EventDTO;
import unicam.IdSProject.models.Event;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-29T15:04:32+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.2 (Oracle Corporation)"
)
@Component
public class EventMapperImpl implements EventMapper {

    @Override
    public Event toEntityWithAllFields(EventCreatedDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Event event = new Event();

        event.setName( dto.getName() );
        event.setMaxAttendees( dto.getMaxAttendees() );
        event.setDescription( dto.getDescription() );
        event.setCollaborators( dto.getCollaborators() );

        return event;
    }

    @Override
    public EventDTO toDtoWithAllFields(Event event) {
        if ( event == null ) {
            return null;
        }

        EventDTO eventDTO = new EventDTO();

        eventDTO.setName( event.getName() );
        eventDTO.setCreator( event.getCreator() );
        eventDTO.setMaxAttendees( event.getMaxAttendees() );
        eventDTO.setDescription( event.getDescription() );
        eventDTO.setCollaborators( event.getCollaborators() );

        return eventDTO;
    }
}
