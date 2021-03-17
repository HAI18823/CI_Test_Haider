package at.spengergasse.spengermed.repository;
import at.spengergasse.spengermed.models.Greeting;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GreetingRepository extends CrudRepository<Greeting, Long> {
    List<Greeting> findByContent(String content);
    Greeting findById(long id);
}
