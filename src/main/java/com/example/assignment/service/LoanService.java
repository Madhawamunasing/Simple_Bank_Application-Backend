package com.example.assignment.service;

import com.example.assignment.collection.Loan;
import com.example.assignment.repository.LoanRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LoanService {
    @Autowired
    private LoanRepository LoanRepo;


    // CRUD Operations methods are here......

    //Create Operation
    public Loan addLoan(Loan loan) {
        loan.setLoanId(UUID.randomUUID().toString().split("-")[0]);
        return LoanRepo.save(loan);
    }

    //Read Operation

    //Get all loan_info
    public List<Loan> getLoans() {
        return LoanRepo.findAll();
    }

    //Get loans by loanId
    public Loan getLoanById(String loanId) {
        return LoanRepo.findById(loanId).get();
    }

    //Get loans by userId
    public List<Loan> getLoanByUserId(String userId) {
        return LoanRepo.findByUserId(userId);
    }

    //Get loans by status
    public List<Loan> LoanByStatus(String loanStatus) {
        return LoanRepo.findLoansByLoanStatus(loanStatus);
    }


    //Update Operations

    //update several details by id
    public Loan updateLoanDetails(String loanId,Loan loanRequest) {
        Loan existingLoan = LoanRepo.findById(loanId).get();
        if (loanRequest.getAmount() != null ) {
            existingLoan.setAmount(loanRequest.getAmount());
        }
        if (loanRequest.getLoanStatus() != null ) {
            existingLoan.setLoanStatus(loanRequest.getLoanStatus());
        }
        if (loanRequest.getType() != null ) {
            existingLoan.setType(loanRequest.getType());
        }
        if (loanRequest.getDescription() != null ) {
            existingLoan.setDescription(loanRequest.getDescription());
        }
        if (loanRequest.getGuaranteeNIC() != null ) {
            existingLoan.setGuaranteeNIC(loanRequest.getGuaranteeNIC());
        }
        if (loanRequest.getGuaranteeName() != null ) {
            existingLoan.setGuaranteeName(loanRequest.getGuaranteeName());
        }
        if (loanRequest.getInstallments() != 0 ) {
            existingLoan.setInstallments(loanRequest.getInstallments());
        }
        if (loanRequest.getInterestRate() != null ) {
            existingLoan.setInterestRate(loanRequest.getInterestRate());
        }
        if (loanRequest.getUserId() != null ) {
            existingLoan.setUserId(loanRequest.getUserId());
        }
        return LoanRepo.save(existingLoan);
    }

    //update all loan details by id
    public Loan updateById (String loanId, Loan loanData) {
        loanData.setLoanId(loanId);
        return LoanRepo.save(loanData);
    }

    //Delete loan by id
    public String deleteLoanById (String loanId) {
        LoanRepo.deleteById(loanId);
        return loanId + "Deleted";
    }


}
