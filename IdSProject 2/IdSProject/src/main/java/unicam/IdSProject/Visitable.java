package unicam.IdSProject;

/**
*
 * This interface is implemented by those who need to be verified by the Curator
 *
 * @author Erika Aguiari, Ilaria Morettini, Luca Barchiesi
 *
 */
public interface Visitable {

    /**
     * This method accepts the Visitor and ridirects the call to the Visitor
     *
     * @param visitor
     */
    void accept(Visitor visitor);
}
