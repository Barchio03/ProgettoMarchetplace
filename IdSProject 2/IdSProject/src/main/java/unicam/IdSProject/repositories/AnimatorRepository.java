package unicam.IdSProject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unicam.IdSProject.models.Product;
import unicam.IdSProject.users.Animator;

@Repository
public interface AnimatorRepository extends CrudRepository<Animator, Long> {
}
