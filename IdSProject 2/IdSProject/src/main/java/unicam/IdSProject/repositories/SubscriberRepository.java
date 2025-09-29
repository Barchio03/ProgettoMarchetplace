package unicam.IdSProject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unicam.IdSProject.ids.SubId;
import unicam.IdSProject.models.Subscriber;
@Repository
public interface SubscriberRepository extends CrudRepository<Subscriber, SubId> {
    void deleteByEventId(Long eventId);
    Iterable<Subscriber> findAllByEventId(Long eventId);
}
