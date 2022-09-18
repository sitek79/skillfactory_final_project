package hm.sitek.pos.controllers;

import hm.sitek.pos.PosapiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = PosapiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CashMachineControllerTest {
    @Autowired
    private TestRestTemplate template;

    @Test
    public void hello_ok() throws Exception {
        ResponseEntity<String> response = template.getForEntity("/settings", String.class);
        assertThat(response.getBody()).isEqualTo("/settings");
    }
}
