package com.ooliuyue.product.controller;

import com.ooliuyue.product.pojo.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: ly
 * @Date: 2019/4/19 09:52
 */

@RequestMapping("/product")
@RestController
public class ProductController {

    @RequestMapping("/get/{id}")
    public Object getProduct(HttpServletRequest request, @PathVariable("id") String id){
        int localPort = request.getLocalPort();
        return new Product(id,"productName:" + localPort);
    }
}
