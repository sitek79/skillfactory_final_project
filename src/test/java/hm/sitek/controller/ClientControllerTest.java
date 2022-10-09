package hm.sitek.controller;

import hm.sitek.exception.ResourceNotFoundException;
import hm.sitek.model.Client;
import hm.sitek.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {
    @Mock
    ClientRepository clientRepository;

    @InjectMocks
    ClientController clientController;

    private Set<Client> cakes = Set.of(new Client(11,555888),
            new Client(12,222333));

    @BeforeEach
    void setUp() {
        //when(clientRepository.findPromotedCakes()).thenReturn(cakes);
        when(clientRepository.findAll().stream().findFirst().toString());
    }

    /*@Test
    void shouldReturnAListOfFoundPromotedCakes() throws ResourceNotFoundException {
        //ModelAndView index = indexController.index();
        ResponseEntity<Client> index = clientController.getClientById(4L);
        //assertThat(index.getModel()).extracting("cakes").contains(cakes);
        assertThat(index.getClass()).extracting("cakes").contains(cakes);
    }*/
}
