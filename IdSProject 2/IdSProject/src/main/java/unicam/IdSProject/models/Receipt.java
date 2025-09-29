package unicam.IdSProject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * This class represents the receipt created after a successful transaction
 *
 * @author Erika Aguiari, Luca Barchiesi
 *
 */
@Entity
@Getter
@Setter
@Table(name="receipts")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String buyer;

    @NotNull
    private String receipt;

}
