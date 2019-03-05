package hello;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    private static final int MILLIS = 1;
    private static final int SECONDS = 1000;

    private AtomicInteger fastCounter = new AtomicInteger(0);
    private AtomicInteger mediumCounter = new AtomicInteger(0);
    private AtomicInteger slowCounter = new AtomicInteger(0);
    private AtomicInteger runtimeExceptionCounter = new AtomicInteger(0);
    private AtomicInteger hossaExceptionCounter = new AtomicInteger(0);
    private AtomicInteger bertaExceptionCounter = new AtomicInteger(0);

    @RequestMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot Hello Application running on host "
                + System.getenv("HOSTNAME")
                + ", fastCounter=" + fastCounter.get()
                + ", mediumCounter=" + mediumCounter.get()
                + ", slowCounter=" + slowCounter.get()
                + ", runtimeExceptionCounter=" + runtimeExceptionCounter.get()
                + ", hossaExceptionCounter=" + hossaExceptionCounter.get()
                + ", bertaExceptionCounter=" + bertaExceptionCounter.get()
                ;
    }

    @RequestMapping("/hello/fast")
    public String fast() {
        randomPause(MILLIS, 30);
        return "Greetings from Spring Boot, fastCounter=" + fastCounter.incrementAndGet();
    }

    @RequestMapping("/hello/fast-berta")
    public String fastBerta() {
        randomPause(MILLIS, 30);
        try {
          throwBertaException();
        } catch(BertaException ihe) {
          // nop
        }
        return "Greetings from Spring Boot, bertaExceptionCounter=" + bertaExceptionCounter.get();
    }

    @RequestMapping("/hello/medium")
    public String medium() {
        randomPause(SECONDS, 5);
        return "Greetings from Spring Boot, mediumCounter=" + mediumCounter.incrementAndGet();
    }

    @RequestMapping("/hello/slow")
    public String slow() {
        randomPause(SECONDS, 10);
        return "Greetings from Spring Boot, slowCounter=" + slowCounter.incrementAndGet();
    }

    @RequestMapping("/hello/exception/runtime")
    public String exceptionRuntime() {
        throw new RuntimeException("" + runtimeExceptionCounter.incrementAndGet());
    }

    @RequestMapping("/hello/exception/hossa")
    public String exceptionHossa() {
        throw new HossaException("" + hossaExceptionCounter.incrementAndGet());
    }

    private static void randomPause(int factor, int maxWait) {
        try {
            Thread.sleep(factor * new Random().nextInt(maxWait));
        } catch (InterruptedException e) {
            //
        }
    }

    private void throwBertaException() {
        throw new BertaException("" + bertaExceptionCounter.incrementAndGet());
    }

}
