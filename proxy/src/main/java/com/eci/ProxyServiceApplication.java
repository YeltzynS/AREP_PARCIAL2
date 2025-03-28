package com.eci;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@RestController
public class ProxyServiceApplication {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final String[] backends = {
            System.getenv().getOrDefault("BACKEND1", "http://localhost:8081"),
            System.getenv().getOrDefault("BACKEND2", "http://localhost:8082")
    };

    private final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        SpringApplication.run(ProxyServiceApplication.class, args);
    }

    @GetMapping("/factors")
    public Object getFactors(@RequestParam("value") int number) {
        int index = counter.getAndIncrement() % backends.length;
        String url = backends[index] + "/factors?value=" + number;
        System.out.println("Forwarding factors request to: " + url);
        return restTemplate.getForObject(url, Object.class);
    }

    @GetMapping("/primes")
    public Object getPrimes(@RequestParam("value") int number) {
        int index = counter.getAndIncrement() % backends.length;
        String url = backends[index] + "/primes?value=" + number;
        System.out.println("Forwarding primes request to: " + url);
        return restTemplate.getForObject(url, Object.class);
    }
}