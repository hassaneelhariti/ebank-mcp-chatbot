package helhariti.ebankservice.controller;

import helhariti.ebankservice.entities.Account;
import helhariti.ebankservice.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccountRestController {
    private AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> getAccounts(){
        return accountService.getAllAccount();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable("id") Long id) {
        return accountService.getAccountById(id);
    }
    @PostMapping("/accounts")
    public Account saveAccount(@RequestBody Account account){
        return accountService.saveAccount(account);
    }


}
