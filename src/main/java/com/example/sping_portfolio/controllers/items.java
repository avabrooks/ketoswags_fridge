package com.example.sping_portfolio.controllers;
/* MVC code that shows defining a simple Model, calling View, and this file serving as Controller
 * Web Content with Spring MVCSpring Example: https://spring.io/guides/gs/serving-web-con
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class items {
    @GetMapping("/items")    // CONTROLLER handles GET request for /greeting, maps it to greeting() and does variable bindings
    public String cart(Model model) {
        ItemBase Eggs = new ItemBase("eggs", "fry, steam, or make deviled eggs", 3,true);
        ItemBase Milk = new ItemBase("milk", "put it in cereal, coffee, or just drink it raw if you're crazy", 4,true);
        ItemBase Ketchup = new ItemBase("ketchup", "put it on eggs, hotdogs, or burgers", 5,false);
        ItemBase Chocolate = new ItemBase("eggs", "eat it and it makes you happy. You can also gift it to people", 8,false);

        List<ItemBase> list = new ArrayList<>();
        list.add(Eggs);
        list.add(Milk);
        list.add(Ketchup);
        list.add(Chocolate);
        System.out.println("ArrayList : " + list);

        model.addAttribute("list", list);

        return "itemcart"; // returns HTML VIEW (greeting)
    }
}