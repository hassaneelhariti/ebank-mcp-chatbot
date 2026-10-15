package helhariti.ebankservice.services;

import helhariti.ebankservice.entities.Account;
import helhariti.ebankservice.feign.CustomerRestClient;
import helhariti.ebankservice.model.Customer;
import helhariti.ebankservice.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {
    private AccountRepository accountRepository;
    private final CustomerRestClient customerRestClient;

    public List<Account> getAllAccount(){
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id){
        Account account=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account not found"));
        account.setCustomer(customerRestClient.findCustomerById(account.getCustomerId()));
        return account;
    }

    public Account saveAccount(Account account){
        try {
            Customer customer =customerRestClient.findCustomerById(account.getCustomerId());
            account.setCreatedAt(LocalDate.now());
            account.setCustomer(customer);
            return accountRepository.save(account);
        } catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }


    }

}
