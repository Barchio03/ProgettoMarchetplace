package unicam.IdSProject.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unicam.IdSProject.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
