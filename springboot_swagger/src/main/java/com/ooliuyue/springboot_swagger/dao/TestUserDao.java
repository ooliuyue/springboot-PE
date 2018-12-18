package com.ooliuyue.springboot_swagger.dao;

import com.ooliuyue.springboot_swagger.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestUserDao extends JpaRepository<User,Integer> {
}
