package hm.sitek;

import hm.sitek.model.Employee;
import hm.sitek.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {

		// String firstName, String lastName, String emailId
		employeeRepository.save(new Employee("Dana", "Smirnova", "user@jkinbox.ru"));

		System.out.println("\nfindAll()");
		employeeRepository.findAll().forEach(x -> System.out.println(x));

		System.out.println("\nfindById(1L)");
		employeeRepository.findById(1l).ifPresent(x -> System.out.println(x));

//		System.out.println("\nfindByName('Node')");
//		repository.findByName("Node").forEach(x -> System.out.println(x));

	}
}
