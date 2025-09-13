package unicam.IdSProject;

public class PlatformHandler {

    private Mailbox mailbox;

    public void blockUser() {}

    public void unblockUser() {}

    public boolean appointCurator() {
        return false;
    }

    public boolean verifyReceivedReceipt() {
        return false;
    }

    public Mailbox getMailbox() {
        return mailbox;
    }
}
