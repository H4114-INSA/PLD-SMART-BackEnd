package com.example.PLDSMARTBackEnd.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin //Allows requests from all origin
@Controller    // This means that this class is a Controller
public class MainController {

    @GetMapping("/")
    public @ResponseBody String index() {
        return "Welcome to the home page!";
    }

}
