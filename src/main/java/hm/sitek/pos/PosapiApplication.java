package hm.sitek.pos;

import hm.sitek.pos.cashmachine.CashMachine;
import hm.sitek.pos.cashmachine.CashMachineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PosapiApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(PosapiApplication.class);

	@Autowired
	private CashMachineRepository repository;

	public static void main(String[] args) {
		log.info("Just a log message.");
		log.debug("Message for debug level.");
//		log.trace("Method 1 started with argument={}", argument);
//		log.debug("Database updated with script = {}", script);
//		log.info("Application has started on port = {}", port);
//		log.warn("Log4j didn't find log4j.properties. Please, provide them");
//		log.error("Connection refused to host = {}", host);
		SpringApplication.run(PosapiApplication.class, args);
	}

	@Override
	public void run(String... args) {

		log.info("StartApplication...");

		// card number: 4276 4000 4109 0201
		repository.save(new CashMachine("RUB", "id1", "100", "0201", "asd123"));

		System.out.println("\nfindAll()");
		repository.findAll().forEach(x -> System.out.println(x));

		System.out.println("\nfindById(1L)");
		repository.findById(1l).ifPresent(x -> System.out.println(x));

//		System.out.println("\nfindByName('Node')");
//		repository.findByName("Node").forEach(x -> System.out.println(x));

	}
}
