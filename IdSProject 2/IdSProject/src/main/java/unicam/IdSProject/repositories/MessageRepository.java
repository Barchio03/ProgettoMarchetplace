package unicam.IdSProject.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import unicam.IdSProject.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message,Long> {
    Iterable<Message> findAllByReceiver(@Param("receiver") String receiver);
}
