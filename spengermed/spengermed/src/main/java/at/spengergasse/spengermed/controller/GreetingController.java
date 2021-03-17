package at.spengergasse.spengermed.controller;
import java.util.concurrent.atomic.AtomicLong;
import at.spengergasse.spengermed.models.Greeting;
import at.spengergasse.spengermed.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class GreetingController {
    @Autowired
    GreetingRepository greetingRepository;

    @GetMapping("/greeting")
    public Iterable<Greeting> greeting (@RequestParam(value = "name",
            defaultValue = "World")String name){
        return greetingRepository.findAll();
    }


}
