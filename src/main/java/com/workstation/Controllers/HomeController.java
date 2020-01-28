package com.workstation.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Šimon Hašák
 */
@Controller
public class HomeController {

    public HomeController(){}

    @RequestMapping("/")
    public String home (){
        return "home";
    }
}
