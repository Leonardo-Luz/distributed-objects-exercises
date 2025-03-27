package ifrs.edu.com.exercise_3;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ifrs.edu.com.exercise_3.database.repositories.ClientRepository;
import ifrs.edu.com.exercise_3.database.repositories.AddressRepository;
import ifrs.edu.com.exercise_3.database.models.Client;
import ifrs.edu.com.exercise_3.database.models.Address;

@Component
public class MainRunner implements CommandLineRunner {

	@Autowired
	ClientRepository clientRep;

	@Autowired
	AddressRepository addressRep;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Running at the command line...");

		// Address address = new Address("address", "city", "cep", "uf");
		// Client client = new Client("name", "email", "phone", address);
		// clientRep.save(client);
		//
		Optional<Client> find_c = clientRep.findById(2);
		// Optional<Address> find_a = addressRep.findById(1);

		if (find_c.isEmpty()) {
			System.out.println("Client not Found!");
		} else {
			System.out.println("");
			System.out.println(find_c.get().toString());
			System.out.println("");
		}
	}
}
