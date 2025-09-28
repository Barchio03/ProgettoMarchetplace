package unicam.IdSProject.ids;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubId implements Serializable {

    private Long eventId;
    private String buyerId;



    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if(!(obj instanceof SubId other)){
            return false;
        }
        else {
            return this.getEventId().equals(other.getEventId()) || this.getBuyerId().equals(other.getBuyerId());
        }
    }

}
