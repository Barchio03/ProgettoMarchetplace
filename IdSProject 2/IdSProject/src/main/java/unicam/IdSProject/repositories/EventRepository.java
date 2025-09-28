package unicam.IdSProject.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unicam.IdSProject.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    public boolean existsByName(String name);
}
