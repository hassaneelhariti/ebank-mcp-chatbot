package helhariti.ebankservice;

import helhariti.ebankservice.entities.Account;
import helhariti.ebankservice.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class EbankServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner insertData(AccountService accountService) {
        return Args -> {
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 5; j++) {
                    Account account = Account.builder()
                            .balance((long) (1000 + Math.random() * 60000))
                            .createdAt(LocalDate.now())
                            .customerId((long) i)
                            .type(Math.random() > 0.5 ? "CURRENT-ACCOUNT" : "SAVING-ACCOUNT")
                            .build();
                    accountService.saveAccount(account);
                }
            }
        };
    }

}
