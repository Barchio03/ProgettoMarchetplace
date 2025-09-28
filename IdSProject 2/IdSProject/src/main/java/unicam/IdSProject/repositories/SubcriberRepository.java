package unicam.IdSProject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unicam.IdSProject.ids.SubId;
import unicam.IdSProject.models.Subscriber;
@Repository
public interface SubcriberRepository extends CrudRepository<Subscriber, SubId> {
    void deleteAllByEventId(Long eventId);
    Iterable<Subscriber> findAllByEventId(Long eventId);
}
