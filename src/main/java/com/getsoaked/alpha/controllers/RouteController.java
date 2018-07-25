package com.getsoaked.alpha.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@CrossOrigin(origins = "http://localhost:8080")
public class RouteController {

    @RequestMapping("^(?!/api).*$")
    public String forward() {
        return "index";
    }
}