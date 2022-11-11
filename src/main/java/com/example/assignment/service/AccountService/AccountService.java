package com.example.assignment.service.AccountService;

import com.example.assignment.collection.Account.Account;
import com.example.assignment.repository.AccountRepository;
//import com.example.mongoTest.model.account.Account;
//import com.example.mongoTest.repository.account.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AccountService {

    public final AccountRepository accountRepository;

    public void createAccount(Account account) {
        accountRepository.insert(account);
    }


    public void updateAccount(String id, Account accountToUpload) {
        accountToUpload.setAccId(id);
        System.out.println(accountToUpload);
        accountRepository.save(accountToUpload);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

//    public AccType[] getAllAccTypes() {
//        return AccType.values();
//    }

    public Optional<List<Account>> findAccByCustomerId(String customerId) {
        return accountRepository.findAccountsByCustomerId(customerId);
    }

    public Optional<Account> findAccByAccId(String accId) {
        return accountRepository.findAccountByAccId(accId);
    }

    public Optional<List<Account>> findAccByHigherAmount(double amount) {
        return accountRepository.findAccountsByAmountIsGreaterThanEqual(amount);
    }

    public Optional<List<Account>> findAccByHigherAmountAndCustomerId(double amount, String customerId) {
        return accountRepository.findAccountsByAmountIsGreaterThanEqualAndCustomerId(amount, customerId);
    }

    public void deleteAccount(String id) {
        accountRepository.deleteAccountByAccId(id);
    }
}
