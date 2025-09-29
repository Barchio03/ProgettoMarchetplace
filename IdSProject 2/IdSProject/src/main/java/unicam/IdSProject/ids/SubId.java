package unicam.IdSProject.ids;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * This class represents the Subscription's composite primary key
 */
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

    @Override
    public int hashCode(){

        final int prime = 31;
        int result = 1;
        long temp;

        temp = this.getEventId().hashCode();
        result = prime*result+(int) (temp^(temp>>>32));

        temp = this.getBuyerId().hashCode();
        result = prime*result+(int) (temp^(temp>>>32));

        return result;

    }

}
