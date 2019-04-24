package com.ooliuyue.product.pojo;

/**
 * @Auther: ly
 * @Date: 2019/4/19 09:50
 */

public class Product {

    private String id;
    private String name;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Product() {
    }

    public void setName(String name) {
        this.name = name;
    }

}
