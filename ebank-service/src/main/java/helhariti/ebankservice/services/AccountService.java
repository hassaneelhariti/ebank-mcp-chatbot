package helhariti.ebankservice.services;

import helhariti.ebankservice.entities.Account;
import helhariti.ebankservice.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {
    private AccountRepository accountRepository;

    public List<Account> getAllAccount(){
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id){

        return accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account not found"));
    }

    public Account saveAccount(Account account){
        account.setCreatedAt(LocalDate.now());
        return accountRepository.save(account);
    }
}
