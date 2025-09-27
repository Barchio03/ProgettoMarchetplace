package unicam.IdSProject;

import lombok.Getter;
import lombok.Setter;
import unicam.IdSProject.models.Product;
import unicam.IdSProject.visitor.Visitable;
import unicam.IdSProject.visitor.Visitor;

@Getter
@Setter
public class ProductWrapper implements Visitable {

    private Product product;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this.product);
    }
}
