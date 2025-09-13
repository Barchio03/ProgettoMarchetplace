package unicam.IdSProject;

/**
 * This interface is implemented by those need to be verified by the curator
 */
public interface Visitable {

    /**
     * Accepts the visitor and ridirects the call to the visitor
     *
     * @param visitor
     */
    public void accept(Visitor visitor);
}
