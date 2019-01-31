package com.example.demo.controller;

import com.example.demo.dao.GoodInfosDao;
import com.example.demo.dao.GoodTypesDao;
import com.example.demo.mapper.GoodDtoMapper;
import com.example.demo.po.GoodInfos;
import com.example.demo.po.GoodTypes;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * mapStruct测试api
 *
 * @author 杨正
 */
@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MapStructTestApi {

    private GoodInfosDao goodInfosDao;
    private GoodTypesDao goodTypesDao;
    private GoodDtoMapper goodDTOMapper;

    @GetMapping("/getGoodInfo/{id}")
    public Object getGoodInfo(@PathVariable Long id){
        //查询商品基本信息
        GoodInfos goodInfos = goodInfosDao.findById(id).get();
        //查询商品类型基本信息
        GoodTypes goodTypes = goodTypesDao.findById(goodInfos.getTypeId()).get();
        //返回转换dto
        return goodDTOMapper.from(goodTypes,goodInfos);
    }
}
