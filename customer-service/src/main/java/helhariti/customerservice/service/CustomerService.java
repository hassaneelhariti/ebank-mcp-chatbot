package helhariti.customerservice.service;

import helhariti.customerservice.entities.Customer;
import helhariti.customerservice.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id){
        return customerRepository.findById(id).orElseThrow(()-> new RuntimeException("Customer not found"));
    }

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}
