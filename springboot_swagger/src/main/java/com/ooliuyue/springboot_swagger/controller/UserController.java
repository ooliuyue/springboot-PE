package com.ooliuyue.springboot_swagger.controller;

import com.ooliuyue.springboot_swagger.dao.TestUserDao;
import com.ooliuyue.springboot_swagger.entity.User;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: ly
 * @Date: 2018/12/18 10:22
 */
@RestController
@RequestMapping(value = "/user")
@Api(value = "用户操作接口",tags = {"用户操作接口"})
public class UserController {
    @Autowired
    private TestUserDao testUserDao;

    @ApiOperation(value="获取用户详细信息", notes="根据用户的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true,paramType = "query", dataType = "Integer")
    @GetMapping(value = "/findById")
    public User findById(@RequestParam(value = "id") int id){
        User user = testUserDao.findOne(id);
        return user;
    }

    @ApiOperation(value="获取用户列表", notes="获取用户列表")
    @GetMapping(value="/getUserList")
    public List getUserList(){
        return testUserDao.findAll();

    }

    @ApiOperation(value="保存用户", notes="保存用户")
    @PostMapping(value="/saveUser")
    public String saveUser(@RequestBody @ApiParam(name="用户对象",value="传入json格式",required=true) User user){
        testUserDao.save(user);
        return "success!";
    }

    @ApiOperation(value="修改用户", notes="修改用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="主键id",required=true,paramType="query",dataType="Integer"),
            @ApiImplicitParam(name="username",value="用户名称",required=true,paramType="query",dataType = "String"),
            @ApiImplicitParam(name="age",value="用户年龄",required=true,paramType="query",dataType = "Integer")
    })
    @GetMapping(value="/updateUser")
    public String updateUser(@RequestParam(value = "id")int id,@RequestParam(value = "username")String username,
                             @RequestParam(value = "age")Integer age){
        User user = new User(id, username, age);
        testUserDao.save(user);
        return "success!";
    }

    @ApiOperation(value="删除用户", notes="根据用户的id来删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true,paramType = "query", dataType = "Integer")
    @DeleteMapping(value="/deleteUserById")
    public String deleteUserById(@RequestParam(value = "id")int id){
        User user = testUserDao.findOne(id);
        testUserDao.delete(user);
        return "success!";
    }

}
