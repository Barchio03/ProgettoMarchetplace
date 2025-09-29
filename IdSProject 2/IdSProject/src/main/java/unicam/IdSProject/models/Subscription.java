package unicam.IdSProject.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import unicam.IdSProject.ids.SubId;

/**
 * This class represents a subscription made by a buyer to an event
 */
@Entity
@Getter
@Setter
@Table(name="subscribers")
@AllArgsConstructor
@IdClass(SubId.class)
@NoArgsConstructor
public class Subscription {
    @Id
    private Long eventId;
    @Id
    private String buyerId;
}
