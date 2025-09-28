package unicam.IdSProject.repositories;
import org.mapstruct.ap.shaded.freemarker.template.utility.StringUtil;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unicam.IdSProject.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    public boolean existsByName(String name );
    public boolean existsByCreator(String creator);
}
