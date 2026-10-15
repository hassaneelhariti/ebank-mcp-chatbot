package helhariti.customerservice;

import helhariti.customerservice.entities.Customer;
import helhariti.customerservice.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner saveCustomers(CustomerService customerService){
        return args->{
            List<String> names=List.of("ali","hassane","ahmed");
            for(String name: names){
                customerService.saveCustomer(
                        Customer.builder()
                                .name(name).email(name+"@gmail.com").build()
                );
            }
        };
    }

}
