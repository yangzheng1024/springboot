package com.example.demo.mapper;

import com.example.demo.po.GoodInfos;
import com.example.demo.po.GoodTypes;
import com.example.demo.vo.GoodDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * 配置vo的映射
 *
 * @author 杨正
 */
@Mapper(componentModel = "spring")
public interface GoodDtoMapper {

    /*public static GoodDtoMapper MAPPER = Mappers.getMapper(GoodDtoMapper.class);*/

    /**
     * 将对象映射成vo
     *
     * @param goodTypes 商品类型实体类
     * @param goodInfos 商品详情实体类
     * @return {@link GoodDTO}
     */
    @Mappings({
            @Mapping(source = "goodInfos.id", target = "goodId"),
            @Mapping(source = "goodInfos.title", target = "goodName"),
            @Mapping(source = "goodInfos.price", target = "goodPrice"),
            @Mapping(source = "goodTypes.name", target = "typeName")
    })
    GoodDTO from(GoodTypes goodTypes, GoodInfos goodInfos);
}
