package com.ooliuyue.eurekaconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: ly
 * @Date: 2019/1/23 17:24
 */

//@RequestMapping("/hello")
//@RestController
public class HelloController {

    @Autowired
    private LoadBalancerClient client;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String hello(@RequestParam String name) {
        name += "!";
        ServiceInstance instance = client.choose("eureka-producer");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/hello/?name=" + name;
        return restTemplate.getForObject(url, String.class);
    }

}