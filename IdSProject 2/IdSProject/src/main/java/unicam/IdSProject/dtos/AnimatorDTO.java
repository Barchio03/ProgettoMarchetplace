package unicam.IdSProject.dtos;

import lombok.Data;
import unicam.IdSProject.models.Mailbox;


@Data
public class AnimatorDTO
{
    private String name;
    private String description;
    private Mailbox mailbox;

}
