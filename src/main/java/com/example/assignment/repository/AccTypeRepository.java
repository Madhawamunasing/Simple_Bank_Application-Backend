package com.example.assignment.repository;

import com.example.assignment.collection.AccType.AccType;
//import com.example.mongoTest.model.account.AccType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccTypeRepository extends MongoRepository<AccType, String> {

    Optional<AccType> findAccTypeByAccTypeId (String accTypeId);

    Optional<AccType> findAccTypeByType (String type);

    int deleteAccTypeByAccTypeId(String accTypeId);
}
