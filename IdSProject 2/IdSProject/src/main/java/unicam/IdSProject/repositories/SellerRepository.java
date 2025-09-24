package unicam.IdSProject.repositories;

import org.springframework.data.repository.CrudRepository;
import unicam.IdSProject.users.Seller;

public interface SellerRepository extends CrudRepository<Seller, String> {
}
