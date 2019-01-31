package com.example.demo.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商品详情实体类
 *
 * @author 杨正
 */
@Entity
@Table(name = "good_infos")
@Data
public class GoodInfos {

    @Id
    @Column(name = "tg_id")
    private Long id;

    @Column(name = "tg_title")
    private String title;

    @Column(name = "tg_price")
    private double price;

    @Column(name = "tg_order")
    private int order;

    @Column(name = "tg_type_id")
    private Long typeId;
}
