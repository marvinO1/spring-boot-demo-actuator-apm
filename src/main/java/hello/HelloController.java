package hello;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    private AtomicInteger counter = new AtomicInteger(0);

    @RequestMapping("/")
    public String index() {        
        return "Greetings from Spring Boot, " + counter.incrementAndGet();
    }
    
}
