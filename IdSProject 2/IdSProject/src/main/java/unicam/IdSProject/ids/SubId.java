package unicam.IdSProject.ids;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
public class SubId implements Serializable {
    @NotNull
    private Long eventId;
    @NotNull
    private String buyerId;



    public boolean equals(Object other){
        //TODO
        return false;
    }

}
