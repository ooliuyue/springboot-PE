package com.ooliuyue.order.controller;

import com.ooliuyue.order.pojo.Order;
import com.ooliuyue.order.utils.LoadBalance;
import com.ooliuyue.order.utils.RandomLoadBalance;
import com.ooliuyue.product.pojo.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: ly
 * @Date: 2019/4/19 10:02
 */

@RequestMapping("/order")
@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    private LoadBalance loadBalance = new RandomLoadBalance();

    @RequestMapping("/get/{id}")
    public Object getOrder(HttpServletRequest request, @PathVariable("id") String id){
        //随机获取host
        String host = loadBalance.chooseServiceHost();
        Product product = restTemplate.getForObject("http://" + host + "/product/get/1", Product.class);
        return new Order(id,"ordername",product);



    }
}
