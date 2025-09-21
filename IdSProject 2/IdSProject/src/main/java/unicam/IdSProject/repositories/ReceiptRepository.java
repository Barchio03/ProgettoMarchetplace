package unicam.IdSProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unicam.IdSProject.models.Receipt;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
}
