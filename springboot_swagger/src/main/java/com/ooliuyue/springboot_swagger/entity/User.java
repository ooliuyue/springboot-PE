package com.ooliuyue.springboot_swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * @Auther: ly
 * @Date: 2018/12/17 17:56
 */
@Entity
@Table(name = "User")
@ApiModel(description = "user")
public class User {

    public User() {

    }

    public User(Integer id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    @ApiModelProperty(value = "主键id",hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "用户名称")
    @Column
    private String username;

    @ApiModelProperty(value = "用户年龄")
    @Column
    private int age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
