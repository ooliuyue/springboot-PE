package com.ooliuyue.order.pojo;

import com.ooliuyue.product.pojo.Product;

/**
 * @Auther: ly
 * @Date: 2019/4/19 09:57
 */

public class Order {

    private String id;
    private String name;
    private Product product;

    public Order(String id, String name, Product product) {
        this.id = id;
        this.name = name;
        this.product = product;
    }

    public Order(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
