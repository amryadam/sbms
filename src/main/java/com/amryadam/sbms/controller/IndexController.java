package com.amryadam.sbms.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @RequestMapping(value = "/")
    public String Index() {
        return "Index";
    }
}
