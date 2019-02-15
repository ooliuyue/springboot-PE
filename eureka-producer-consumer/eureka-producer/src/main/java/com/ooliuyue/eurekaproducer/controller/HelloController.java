package com.ooliuyue.eurekaproducer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Auther: ly
 * @Date: 2019/1/23 17:01
 */

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/")
    public String hello(@RequestParam String name) {
        return "Hello, " + name + " " + new Date();
    }

}