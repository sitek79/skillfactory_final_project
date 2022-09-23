package hm.sitek.repository;

import hm.sitek.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    //List<Client> findByPublished(boolean published);
    //List<Client> findByTitleContaining(long balance);
    List<Client> findByBalanceContaining(long balance);
}