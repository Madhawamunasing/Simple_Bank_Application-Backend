package com.example.assignment.repository;

import com.example.assignment.collection.Loan;
import com.example.assignment.collection.LoanType;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface LoanRepository extends MongoRepository<Loan,String> {
    List<Loan> findByUserId(String userId);

    List<Loan> findLoansByLoanStatus(String loanStatus);

}
