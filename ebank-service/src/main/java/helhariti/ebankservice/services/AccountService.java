package helhariti.ebankservice.services;

import helhariti.ebankservice.entities.Account;
import helhariti.ebankservice.feign.CustomerRestClient;
import helhariti.ebankservice.model.Customer;
import helhariti.ebankservice.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {
    private AccountRepository accountRepository;
    private final CustomerRestClient customerRestClient;
    @McpTool(description = "get all accounts")
    public List<Account> getAllAccount(){
        return accountRepository.findAll();
    }

    @McpTool(description = "get an account by id")
    public Account getAccountById(@McpToolParam(description = "account id to get") Long id){
        Account account=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account not found"));
        account.setCustomer(customerRestClient.findCustomerById(account.getCustomerId()));
        return account;
    }

    @McpTool(description = "save an accounts")
    public Account saveAccount(@McpToolParam(description = "account to save (customer id,balance, type(current account or saving account))") Account account){
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
