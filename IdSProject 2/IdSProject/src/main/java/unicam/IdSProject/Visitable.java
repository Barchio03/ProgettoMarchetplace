package unicam.IdSProject;

/**
 * This interface is implemented by those who need to be verified by the Curator
 */
public interface Visitable {

    /**
     * Accepts the Visitor and ridirects the call to the Visitor
     *
     * @param visitor
     */
    void accept(Visitor visitor);
}
