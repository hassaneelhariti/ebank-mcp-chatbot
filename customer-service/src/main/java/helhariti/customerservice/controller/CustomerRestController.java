package helhariti.customerservice.controller;

import helhariti.customerservice.entities.Customer;
import helhariti.customerservice.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerRestController {
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable  Long id){
        return customerService.getCustomer(id);
    }

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }
}
