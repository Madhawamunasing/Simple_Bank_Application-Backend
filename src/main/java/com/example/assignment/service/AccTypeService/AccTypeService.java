package com.example.assignment.service.AccTypeService;

import com.example.assignment.collection.AccType.AccType;
import com.example.assignment.repository.AccTypeRepository;
//import com.example.mongoTest.model.account.AccType;
//import com.example.mongoTest.repository.account.AccTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AccTypeService {

    public final AccTypeRepository accountRepository;

    public ResponseEntity<String> createAccType(AccType account) {
        try {
            accountRepository.insert(account);
            ResponseEntity<String> responseEntity = new ResponseEntity<>("Created Succesfully!",
                    HttpStatus.OK);
            return responseEntity;
        } catch (Exception e) {
            ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),
                    HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
    }


    public void updateAccType(String id, AccType accountToUpload) {
        accountToUpload.setAccTypeId(id);
        accountRepository.save(accountToUpload);
    }

    public List<AccType> getAllAccTypes() {
        return accountRepository.findAll();
    }

    public Optional<AccType> getAccTypeByAccTypeId(String accTypeId) {
        return accountRepository.findAccTypeByAccTypeId(accTypeId);
    }

    public Optional<AccType> getAccTypeByType(String type) {
        return accountRepository.findAccTypeByType(type);
    }

    public void deleteAccType(String id) {
        accountRepository.deleteAccTypeByAccTypeId(id);
    }
}
