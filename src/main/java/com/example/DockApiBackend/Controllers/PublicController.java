package com.example.DockApiBackend.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.HTML;


@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping("")
    public String publicHome(){
        return "Welcome to the public home page";
    }
}
