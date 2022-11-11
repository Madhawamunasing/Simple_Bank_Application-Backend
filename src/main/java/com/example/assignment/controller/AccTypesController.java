package com.example.assignment.controller;

//import com.example.mongoTest.model.accType.AccType;
//import com.example.mongoTest.model.accType.AccType;
//import com.example.mongoTest.model.account.AccType;
//import com.example.mongoTest.service.AccTypeService;
import com.example.assignment.collection.AccType.AccType;
import com.example.assignment.service.AccTypeService.AccTypeService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/accTypes")
@AllArgsConstructor
public class AccTypesController {
    private final AccTypeService accTypeService;


    @PostMapping
    public void addAccType(@RequestBody AccType accType) {
        accTypeService.createAccType(accType);
    }

    @PutMapping(path = "{id}")
    public void updateAccType(@PathVariable("id") String accId,  @NonNull @RequestBody AccType accTypeToUpload) {
        accTypeService.updateAccType(accId, accTypeToUpload);
    }

    @GetMapping
    public List<AccType> getAllAccTypes() {
        return accTypeService.getAllAccTypes();
    }

    @GetMapping(path = "/getAccTypeByAccTypeId/{id}")
    public Optional<AccType> getAccTypeByAccTypeId(@PathVariable("id") String accTypeId) {
        return accTypeService.getAccTypeByAccTypeId(accTypeId);
    }

    @GetMapping(path = "/getAccTypeByType/{type}")
    public Optional<AccType> getAccTypeByType(@PathVariable("type") String type) {
        return accTypeService.getAccTypeByType(type);
    }

    @DeleteMapping(path = "{id}")
    public void deleteAccTypeById(@PathVariable("id") String accId) {
        accTypeService.deleteAccType(accId);
    }


//    @GetMapping(path = "/accTypes")
//    public AccType[] getAllAccTypes() {
//        return accTypeService.getAllAccTypes();
//    }

}
