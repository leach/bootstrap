package com.anythy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Map;

/**
 * Created by Leach on 0011 2017/10/11.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Map<String,Object> map){
        map.put("nowDate", LocalDate.now());
        return "/login";
    }
}
