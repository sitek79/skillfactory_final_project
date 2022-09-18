package hm.sitek.pos.test.repos;

import hm.sitek.pos.test.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message, Long> {
}
