package unicam.IdSProject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import unicam.IdSProject.ids.SubId;
import unicam.IdSProject.models.Subscription;
@Repository
public interface SubscriberRepository extends CrudRepository<Subscription, SubId> {
    Iterable<Subscription> findAllByEventId(Long eventId);
}
