package com.anythy.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

/**
 * Created by Leach on 0010 2017/10/10.
 */
@Controller
public class HomeController {

    private LocalDate localDate = LocalDate.now();

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String welcome(HttpSession session){
        session.getAttributeNames();
        return "/home";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @PreAuthorize("hasRole('test')")
    public String test(HttpSession session){
        session.getAttributeNames();
        return "/home";
    }

    @RequestMapping(value = "/deny1", method = RequestMethod.GET)
    public String deny(HttpSession session){
        session.getAttributeNames();
        return "/deny";
    }
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error(HttpSession session){
        session.getAttributeNames();
        return "/error";
    }
}
