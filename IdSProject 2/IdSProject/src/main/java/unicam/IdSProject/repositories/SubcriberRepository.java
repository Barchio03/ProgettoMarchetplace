package unicam.IdSProject.repositories;

import org.springframework.data.repository.CrudRepository;
import unicam.IdSProject.ids.SubId;
import unicam.IdSProject.models.Subscriber;

public interface SubcriberRepository extends CrudRepository<Subscriber, SubId> {
}
