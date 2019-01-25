package com.example.demo.po;

import lombok.Data;

import javax.persistence.*;

/**
 * 用户实体类
 *
 * @author 杨正
 */
@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private Integer age;
}
