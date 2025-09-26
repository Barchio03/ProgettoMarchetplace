package unicam.IdSProject.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unicam.IdSProject.models.Receipt;

@Repository
public interface ReceiptRepository extends CrudRepository<Receipt, Long> {

}
