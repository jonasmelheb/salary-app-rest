package com.younes.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalaryController {
    @RequestMapping("/")
    public String index() {
        return "Votre Controller à été bien créé";
    }
}
