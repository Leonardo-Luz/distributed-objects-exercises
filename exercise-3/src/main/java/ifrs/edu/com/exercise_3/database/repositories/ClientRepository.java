package ifrs.edu.com.exercise_3.database.repositories;

import org.springframework.data.repository.CrudRepository;
import ifrs.edu.com.exercise_3.database.models.Client;

public interface ClientRepository extends CrudRepository<Client, Integer> {}
