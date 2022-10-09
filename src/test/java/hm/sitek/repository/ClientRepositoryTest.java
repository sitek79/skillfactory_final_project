package hm.sitek.repository;

import hm.sitek.model.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ClientRepositoryTest {
    @Autowired
    private ClientRepository productRepository;
    private Client client;
    @BeforeEach
    public void setUp() {
        client = new Client(10,555888);
    }
    @AfterEach
    public void tearDown() {
        productRepository.deleteAll();
        client = null;
    }
}
