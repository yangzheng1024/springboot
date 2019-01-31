package com.example.demo.dao;

import com.example.demo.po.GoodInfos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 商品详情dao
 *
 * @author 杨正
 */
public interface GoodInfosDao extends JpaRepository<GoodInfos, Long> {
}
