package ifrs.edu.com.exercise_3;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ifrs.edu.com.exercise_3.database.repositories.ClientRepository;
import ifrs.edu.com.exercise_3.database.models.Client;

@Component
public class MainRunner implements CommandLineRunner{

	@Autowired
	ClientRepository clientRep;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Running at the command line...");

		// INSERT
		// Client client = new Client("Roberto Carlos", "perna.de.pau@hotmail.com", "69 96969696", "Pérola Negra", "Cidade mágica", "952000", "OZ");
		//
		// clientRep.save(client);

		Optional<Client> find = clientRep.findById(1);

		if (find.isEmpty()) {
			System.out.println("Client not Found!");
		}
		else {
			System.out.println(find.get().toString());
		}
	}
}
