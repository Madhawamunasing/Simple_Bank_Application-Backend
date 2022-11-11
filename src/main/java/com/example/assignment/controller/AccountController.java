package com.example.assignment.controller;

//import com.example.mongoTest.model.account.Account;
//import com.example.mongoTest.service.AccTypeService;
//import com.example.mongoTest.service.AccountService;
import com.example.assignment.collection.Account.Account;
import com.example.assignment.service.AccTypeService.AccTypeService;
import com.example.assignment.service.AccountService.AccountService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/accounts")
@AllArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public void addAccount(@RequestBody Account account) {
        accountService.createAccount(account);
    }

    @PutMapping(path = "{id}")
    public void updateAccount(@PathVariable("id") String accId, @NonNull @RequestBody Account accountToUpload) {
        accountService.updateAccount(accId, accountToUpload);
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping(path = "{id}")
    public Optional<List<Account>> findAccByCustomerId(@PathVariable("id") String id) {
        return accountService.findAccByCustomerId(id);
    }

    @GetMapping(path = "/getAccountByAccId/{id}")
    public Optional<Account> findAccByAccId(@PathVariable("id") String id) {
//        Optional<Account> account = accountService.findAccByAccId(id);
//         accTypeService.getAccTypeByAccTypeId(account.get().getAccTypeId().toString());
         return accountService.findAccByAccId(id);
    }

    @GetMapping(path = "/getHigherAmountAccounts/{amount}")
    public Optional<List<Account>> findAccByHigherAmount(@PathVariable("amount") double amount) {
        return accountService.findAccByHigherAmount(amount);
    }

    @PostMapping(path = "/getHigherAmountAccountsAndCustomerId")
    public Optional<List<Account>> findAccByHigherAmountAndCustomerId(@RequestBody Map<String, String> json) {
        return accountService.findAccByHigherAmountAndCustomerId(Double.parseDouble(json.get("amount")), json.get("customerId"));
    }

    @DeleteMapping(path = "{id}")
    public void deleteAccountById(@PathVariable("id") String accId) {
        accountService.deleteAccount(accId);
    }


//    @GetMapping(path = "/accTypes")
//    public AccType[] getAllAccTypes() {
//        return accountService.getAllAccTypes();
//    }

}
