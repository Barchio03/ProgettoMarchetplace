package unicam.IdSProject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unicam.IdSProject.models.ProducerProduct;

@Repository
public interface ProducerProductRepository extends CrudRepository<ProducerProduct, Long> {
}
