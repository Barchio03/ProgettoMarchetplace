package unicam.IdSProject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * This class represents the Location expressed with coordinates that a Seller can add to its profile
 *
 * @author Erika Aguiari, Luca Barchiesi
 *
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name="locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String latitude;

    @NotNull
    private String longitude;

    @Override
    public String toString() { return this.latitude+this.longitude; }

    @Override
    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        if (obj instanceof Location location) {
            return this.getLatitude().equals(location.getLatitude()) && this.getLongitude().equals(location.getLongitude());
        }
        return false;
    }
}
