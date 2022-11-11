package com.example.assignment.collection.Account;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@Document(collection = "Account")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {
    @Id
    private String accId;
    private double amount;
//    @DBRef
    private String accTypeId;
    private LocalDateTime created;
    private boolean isActive;
//    @DBRef
    private String customerId;


}
