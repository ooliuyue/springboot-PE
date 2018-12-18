package com.ooliuyue.springboot_swagger;

import com.ooliuyue.springboot_swagger.dao.TestUserDao;
import com.ooliuyue.springboot_swagger.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootSwaggerApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private TestUserDao testUserDao;

    @Test
    public void insert(){
        User user = new User();
        user.setUsername("张三");
        user.setAge(23);
        testUserDao.save(user);
    }

    @Test
    public void update(){
        User user = new User();
        user.setId(1);
        user.setAge(18);
        user.setUsername("李四");
        testUserDao.save(user);
    }

    @Test
    public void select() {
        User user = testUserDao.findOne(1);
        System.out.println(user);
    }

    @Test
    public void delete() {
        testUserDao.delete(1);
    }
}

