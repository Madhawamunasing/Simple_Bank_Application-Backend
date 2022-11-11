package com.example.assignment.repository;

//import com.example.mongoTest.model.account.Account;
import com.example.assignment.collection.Account.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends MongoRepository<Account, String> {

    Optional<List<Account>> findAccountsByCustomerId(String customerId);

    Optional<Account> findAccountByAccId(String accId);

    Optional<List<Account>> findAccountsByAmountIsGreaterThanEqual(double amount);

    Optional<List<Account>> findAccountsByAmountIsGreaterThanEqualAndCustomerId(double amount, String customerId);

//    int findAccountAndM;

    int deleteAccountByAccId(String accId);


}
