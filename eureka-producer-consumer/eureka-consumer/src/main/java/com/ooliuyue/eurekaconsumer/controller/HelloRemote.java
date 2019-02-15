package com.ooliuyue.eurekaconsumer.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: ly
 * @Date: 2019/1/25 10:40
 */

@FeignClient(name = "eureka-producer")
@Component
public interface HelloRemote {

    @GetMapping("/hello/")
    String hello(@RequestParam(value = "name") String name);

}