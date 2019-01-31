package com.example.demo.vo;

import lombok.Data;

/**
 * 商品DTO
 *
 * @author 杨正
 */
@Data
public class GoodDTO {

    // 商品编号
    private Long goodId;

    // 商品名称
    private String goodName;

    // 商品价格
    private double goodPrice;

    // 类型名称
    private String typeName;
}
