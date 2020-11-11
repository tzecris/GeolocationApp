package com.user.project.userApp.controllers;

import com.user.project.userApp.entities.User;
import com.user.project.userApp.services.UserService;
import com.user.project.userApp.services.ValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("app/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ValidationErrorService validationErrorService;

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("")
    public ResponseEntity saveUser(@Valid @RequestBody User user, BindingResult result){
        ResponseEntity<?> errorMap = validationErrorService.validationService(result,user);
        if (errorMap!=null) return errorMap;
        User user1 = userService.saveUser(user);
        return new ResponseEntity<User>(user1,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") String id){
        User user = userService.findById(id);
        if(user!=null){
            return ResponseEntity.ok(user);
        }else{
           return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity findByText(@RequestParam(value = "text",required = true) String text){
        List<User> users = userService.findByAfmOrName(text);
            return ResponseEntity.ok(users);

    }
}
