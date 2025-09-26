package unicam.IdSProject.ids;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class SubId implements Serializable {

    private Long eventId;
    private String buyerId;



    public boolean equals(Object other){
        //TODO
        return false;
    }

}
