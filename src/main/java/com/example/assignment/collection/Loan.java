package com.example.assignment.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Loan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
    @Id
    private String loanId;
    private Double amount;
    private LoanType type;
    private String description;
    private int installments;
    private String userId;
    private String guaranteeNIC;
    private String guaranteeName;
    private LoanStatus loanStatus;
    private String interestRate;
}
