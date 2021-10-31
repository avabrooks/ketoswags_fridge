package com.example.sping_portfolio.data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

// Built using article: https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html
// or similar: https://asbnotebook.com/2020/04/11/spring-boot-thymeleaf-form-validation-example/
@Controller
public class UserSqlMvcController implements WebMvcConfigurer {

    // Autowired enables Control to connect HTML and POJO Object to Database easily for CRUD
    @Autowired
    private UserSqlRepository repository;

    /*  The HTML template Forms and PersonForm attributes are bound
        @return - template for person form
        @param - Person Class

    */

    @GetMapping("/signup")
    public String personAdd(User user) {
        System.out.println("personAdd");

        return "/user/signup";
    }

    /* Gathers the attributes filled out in the form, tests for and retrieves validation error
    @param - Person object with @Valid
    @param - BindingResult object
     */
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