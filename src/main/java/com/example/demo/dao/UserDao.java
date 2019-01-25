package com.example.demo.dao;

import com.example.demo.po.User;
import org.springframework.data.repository.CrudRepository;

/**
 * 用户dao
 *
 * @author 杨正
 */
public interface UserDao extends CrudRepository<User, Long> {
}
