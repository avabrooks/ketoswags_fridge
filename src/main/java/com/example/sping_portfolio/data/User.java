package com.example.sping_portfolio.data;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;


@Setter
@Getter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(min=8)
    private String password;

    @NonNull
    @Size(min = 2, max = 30, message = "Name (2 to 30 chars)")
    private String name;


    /* Initializer*/
    public User(String password, String name) {
        this.password = password;
        this.name = name;
    }

    public String getName(){
        return name;
    }


}