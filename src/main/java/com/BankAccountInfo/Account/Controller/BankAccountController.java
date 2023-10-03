package com.BankAccountInfo.Account.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.BankAccountInfo.Account.Model.Account;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class BankAccountController {

    @Autowired
    private com.BankAccountInfo.Account.Service.BankAccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @GetMapping("/allAccounts")
    public List<Account> getAllAccounts(){
    	return accountService.findAllAccounts();
	
    	
    }
    
    @PostMapping("/deposit/{id}")
    public Account deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double Balance = request.get("Balance");
        return accountService.deposit(id, Balance);
    }

    @PostMapping("/withdraw/{id}")
    public Account withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
    	Double Balance = request.get("Balance");
        return accountService.withdraw(id, Balance);
    }
}