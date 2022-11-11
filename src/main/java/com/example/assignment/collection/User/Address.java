package com.example.assignment.collection.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String street1;
    private String street2;
    private String town;
    private String city;
    private Integer postalCode;

}