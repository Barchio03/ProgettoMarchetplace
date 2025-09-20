package unicam.IdSProject.Models.DTOs;

import unicam.IdSProject.Models.Mailbox;

public class AnimatorDTO
{
    private String name;

    private String description;

    private Mailbox mailbox;

    public AnimatorDTO(String name, String description,Mailbox mailbox){
        this.name = name;
        this.description = description;
        this.mailbox = mailbox;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Mailbox getMailbox() {
        return mailbox;
    }

    public void setMailbox(Mailbox mailbox) {
        this.mailbox = mailbox;
    }
}
