package unicam.IdSProject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unicam.IdSProject.models.TransformerProduct;

@Repository
public interface TransformerProductRepository extends CrudRepository<TransformerProduct, Long> {
}
