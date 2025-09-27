package unicam.IdSProject;

import lombok.Getter;
import lombok.Setter;
import unicam.IdSProject.models.Event;
import unicam.IdSProject.visitor.Visitable;
import unicam.IdSProject.visitor.Visitor;

@Getter
@Setter
public class EventWrapper implements Visitable {

    private Event event;


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this.event);
    }
}
