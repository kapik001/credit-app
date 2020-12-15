package com.kapusta.webapp.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping(value = "loginintoapplication/{login}/{password}")
    public Boolean login(@PathVariable String login,@PathVariable String password){
        System.out.println(login + " " + password);
        return true;
    }
}
