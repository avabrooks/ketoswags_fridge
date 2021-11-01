package com.example.sping_portfolio.data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserSqlMvcController implements WebMvcConfigurer {


    @Autowired
    private UserSqlRepository repository;



    @GetMapping("/signup")
    public String personAdd(User user) {
        System.out.println("personAdd");

        return "/user/signup";
    }

    @PostMapping("/signup")
    public String personSave(@Valid User user, BindingResult bindingResult) {
        // Validation of Decorated PersonForm attributes
        System.out.println("personSave");
        if (bindingResult.hasErrors()) {
            return "user/signup";
        }
        repository.save(user);
        System.out.println(user.getName());
        // Redirect to next step
        return "user/profile";
    }


    @RequestMapping(value = "/api/people/get")
    public ResponseEntity<List<User>> getPeople() {
        return new ResponseEntity<>( repository.listAll(), HttpStatus.OK);
    }

    /*
    GET individual Person using ID
     */
    @RequestMapping(value = "/api/person/get/{id}")
    public ResponseEntity<User> getPerson(@PathVariable long id) {
        return new ResponseEntity<>( repository.get(id), HttpStatus.OK);
    }



    /*
    POST Aa record by Requesting Parameters from URI
     */
    @RequestMapping(value = "/api/person/post", method = RequestMethod.POST)
    public ResponseEntity<Object> postPerson(@RequestParam("password") String password,
                                             @RequestParam("name") String name) {

        // A person object WITHOUT ID will create a new record
        User person = new User(password, name);
        repository.save(person);
        return new ResponseEntity<>(name +" is created successfully", HttpStatus.CREATED);
    }

}