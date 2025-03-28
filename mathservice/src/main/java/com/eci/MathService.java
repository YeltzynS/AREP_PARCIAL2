package com.eci;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class MathService {

    public static void main(String[] args) {
        SpringApplication.run(MathService.class, args);
    }

    // Endpoint para cálculo de factores
    @GetMapping("/factors")
    public MathResult calculateFactors(@RequestParam("value") int number) {
        List<Integer> factors = findFactors(number);
        return new MathResult("factors", number, factors);
    }

    // Endpoint para cálculo de números primos
    @GetMapping("/primes")
    public MathResult calculatePrimes(@RequestParam("value") int number) {
        List<Integer> primes = findPrimesUpTo(number);
        return new MathResult("primes", number, primes);
    }

    // Método para encontrar factores
    private List<Integer> findFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        factors.add(1); // 1 es factor de todos los números

        for (int i = 2; i <= number/2; i++) {
            if (number % i == 0) {
                factors.add(i);
            }
        }

        if (number > 1) {
            factors.add(number); // Todo número es factor de sí mismo
        }

        return factors;
    }

    // Método para encontrar números primos
    private List<Integer> findPrimesUpTo(int number) {
        List<Integer> primes = new ArrayList<>();
        if (number >= 1) {
            primes.add(1); // Consideramos 1 como primo para este caso
        }

        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        return primes;
    }

    // Método auxiliar para verificar si un número es primo
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Clase interna para el formato de respuesta unificado
    static class MathResult {
        private final String operation;
        private final int input;
        private final List<Integer> output;

        public MathResult(String operation, int input, List<Integer> output) {
            this.operation = operation;
            this.input = input;
            this.output = output;
        }

        // Getters
        public String getOperation() { return operation; }
        public int getInput() { return input; }
        public List<Integer> getOutput() { return output; }
    }
}
