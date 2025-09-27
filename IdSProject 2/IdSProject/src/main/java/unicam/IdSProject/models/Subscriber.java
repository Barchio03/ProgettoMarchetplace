package unicam.IdSProject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import unicam.IdSProject.ids.SubId;

@Entity
@Getter
@Setter
@Table(name="subscribers")
@AllArgsConstructor
@IdClass(SubId.class)
public class Subscriber {
    @Id
    private Long eventId;
    @Id
    private String buyerId;
}
