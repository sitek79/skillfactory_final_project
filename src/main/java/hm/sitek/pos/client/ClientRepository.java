package hm.sitek.pos.client;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {
    List<Client> findByLastName(@Param("name") String name);
}