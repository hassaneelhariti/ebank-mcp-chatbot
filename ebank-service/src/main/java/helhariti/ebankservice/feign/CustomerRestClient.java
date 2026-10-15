package helhariti.ebankservice.feign;

import helhariti.ebankservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "defaultCustomerById")
    Customer findCustomerById(@PathVariable Long id);

    default Customer defaultCustomerById(Long id, Exception e) {
        return Customer.builder()
                .id(id)
                .name("Default-name")
                .email("default-name@gmail.com")
                .build();
    }
}
