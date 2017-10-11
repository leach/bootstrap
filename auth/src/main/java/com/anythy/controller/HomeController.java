package com.anythy.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * Created by Leach on 0010 2017/10/10.
 */
@RestController
public class HomeController {

    private LocalDate localDate = LocalDate.now();

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String welcome(){
        return String.format("Hello! %s", localDate);
    }
}
