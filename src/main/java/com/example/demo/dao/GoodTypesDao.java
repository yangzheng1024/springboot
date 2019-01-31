package com.example.demo.dao;

import com.example.demo.po.GoodTypes;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 商品类型dao
 *
 * @author 杨正
 */
public interface GoodTypesDao extends JpaRepository<GoodTypes, Long> {
}
