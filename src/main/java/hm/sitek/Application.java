package hm.sitek;

import hm.sitek.model.Client;
import hm.sitek.model.Operations;
import hm.sitek.repository.ClientRepository;
import hm.sitek.repository.OperationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	OperationsRepository operationsRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {

		// генерируем случайную сумму внесения наличных
		long leftLimit = 1L;
		long rightLimit = 10000000L;
		long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
		long amount = generatedLong;

		// Client Repository
		clientRepository.save(new Client(10, amount));
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
		//
		System.out.println("\ngetOperationList");
		operationsRepository.findAll();
		//
		// work With OperationsRepository
		operationsRepository.save(new Operations(1, 1, 2, amount));
	}
}
