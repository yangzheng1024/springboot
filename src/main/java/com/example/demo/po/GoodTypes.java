package com.example.demo.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商品类型实体
 *
 * @author 杨正
 */
@Entity
@Table(name = "good_types")
@Data
public class GoodTypes {

    @Id
    @Column(name = "tgt_id")
    private Long id;

    @Column(name = "tgt_name")
    private String name;

    @Column(name = "tgt_is_show")
    private int show;

    @Column(name = "tgt_order")
    private int order;
}
