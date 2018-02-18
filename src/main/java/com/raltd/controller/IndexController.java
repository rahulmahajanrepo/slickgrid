package com.raltd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by mbart on 28.02.2016.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String showIndex(Model model) {
        return "index"; // return index.html Template
    }
}
