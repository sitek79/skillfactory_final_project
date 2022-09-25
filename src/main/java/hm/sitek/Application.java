package hm.sitek;

import hm.sitek.model.Client;
import hm.sitek.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	ClientRepository clientRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {

		// Client Repository
		clientRepository.save(new Client(10,555888));
		// findAll()
		System.out.println("\nfindAll()");
		clientRepository.findAll().forEach(x -> System.out.println(x));
		// findById()
		System.out.println("\nfindById(1L)");
		clientRepository.findById(2l).ifPresent(x -> System.out.println(x));
		//
		// getBalance()
		System.out.println("\ngetBalance()");
		clientRepository.getBalance();
		// putMoney()
		System.out.println("\nputMoney");
		clientRepository.putMoney();
		// takeMoney()
		System.out.println("\ntakeMoney");
		clientRepository.takeMoney();
	}
}
