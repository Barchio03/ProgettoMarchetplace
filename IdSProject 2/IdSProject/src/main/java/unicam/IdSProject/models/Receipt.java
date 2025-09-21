package unicam.IdSProject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import unicam.IdSProject.users.Buyer;

@Entity
@Getter
@Setter
@Table(name="receipts")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Buyer buyer;

    @NotNull
    private String receipt;

}
