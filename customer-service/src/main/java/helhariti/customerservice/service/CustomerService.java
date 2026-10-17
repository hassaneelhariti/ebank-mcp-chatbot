package helhariti.customerservice.service;

import helhariti.customerservice.entities.Customer;
import helhariti.customerservice.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    @McpTool(description = "Get all customers")
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    @McpTool(description = "get one customer by its id")
    public Customer getCustomer(@McpToolParam(description = "customer id") Long id){
        return customerRepository.findById(id).orElseThrow(()-> new RuntimeException("Customer not found"));
    }

    @McpTool(description = "save a customer ")
    public Customer saveCustomer(@McpToolParam(description = "the customer to save avec son name, email") Customer customer){
        return customerRepository.save(customer);
    }
}
