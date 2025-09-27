package unicam.IdSProject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unicam.IdSProject.users.Seller;
@Repository
public interface SellerRepository extends CrudRepository<Seller, String> {
}
