package hm.sitek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	static final String URL_EMPLOYEES = "http://localhost:8080/clients";
	static final String URL_EMPLOYEES_XML = "http://localhost:8080/clients.xml";
	static final String URL_EMPLOYEES_JSON = "http://localhost:8080/clients.json";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		//
		RestTemplate restTemplate = new RestTemplate();
		// Send request with GET method and default Headers.
		String result = restTemplate.getForObject(URL_EMPLOYEES, String.class);
		System.out.println(result);

	}
}
