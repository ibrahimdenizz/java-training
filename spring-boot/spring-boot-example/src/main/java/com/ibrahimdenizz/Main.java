package com.ibrahimdenizz;

import java.util.List;
// import java.util.Objects;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/customer")
public class Main {
    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public record NewCustomerRequest(String name, String email, Integer age) {
    }

    @PostMapping
    public void createCustomer(@RequestBody NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerRepository.save(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        customerRepository.deleteById(id);
    }

    public record UpdateCustomerRequest(Optional<String> name, Optional<String> email, Optional<Integer> age) {
    }

    @PutMapping("{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") Integer id, @RequestBody UpdateCustomerRequest request) {
        Optional<Customer> tryCustomer = customerRepository.findById(id);
        Customer customer = tryCustomer.orElseThrow();

        request.name().ifPresent(name -> customer.setName(name));
        request.email().ifPresent(email -> customer.setEmail(email));
        request.age().ifPresent(age -> customer.setAge(age));

        Customer newCustomer = customerRepository.save(customer);
        return newCustomer;
    }

    @GetMapping("/greet")
    public GreetResponse greet() {
        GreetResponse response = new GreetResponse("Hello World!", List.of("Java", "Kotlin", "Scala"),
                new Person("Ibrahim", 23, 1000.0));
        return response;
    }

    record Person(String name, int age, double savings) {
    }

    public record GreetResponse(String greet, List<String> favProgrammingLanguages, Person person) {
    }

    // class GreetResponse {
    // private final String greet;

    // public GreetResponse(String greet) {
    // this.greet = greet;
    // }

    // public String getGreet() {
    // return greet;
    // }

    // @Override
    // public String toString() {
    // return "GreetResponse{" +
    // "greet='" + greet + '\'' +
    // '}';
    // }

    // @Override
    // public boolean equals(Object o) {
    // if (this == o)
    // return true;
    // if (o == null || getClass() != o.getClass())
    // return false;
    // GreetResponse that = (GreetResponse) o;
    // return Objects.equals(greet, that.greet);
    // }

    // @Override
    // public int hashCode() {
    // return Objects.hash(greet);
    // }
    // }
}
