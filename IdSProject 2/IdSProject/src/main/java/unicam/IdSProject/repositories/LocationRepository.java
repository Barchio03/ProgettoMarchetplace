package unicam.IdSProject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unicam.IdSProject.models.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
}
