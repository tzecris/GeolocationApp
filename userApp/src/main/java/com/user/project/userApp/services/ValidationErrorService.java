package com.user.project.userApp.services;

import com.user.project.userApp.entities.User;
import org.fenixedu.TINValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class ValidationErrorService {

    @Autowired
    GeoCoder geoCoder;

    public ResponseEntity<?> validationService(BindingResult result, User user) {
        Map<String, String> errorMap = new HashMap<>();
        if (result.hasErrors()) {
            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
        }
        validateGeolocation(errorMap,user);
        afmValidator(errorMap,user);
        if(!errorMap.isEmpty()) return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);

        return null;
    }

    private void validateGeolocation(Map<String, String> errorMap, User user){
       if( geoCoder.getGeolocation(user.getAddress())==null){
           errorMap.put("address","Given address was invalid!");
       }
    }

    private void afmValidator(Map<String, String> errorMap,User user){
       if ( !TINValidator.isValid("EL", user.getAfm())){
           errorMap.put("afm","Given AFM was invalid!");
       }

    }
}
