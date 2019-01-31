# springboot
#### 1.MapStruct使用方法

> MapStruct是一种类型安全的bean映射类生成java注释处理器。

> [文档参考（https://www.jianshu.com/p/3f20ca1a93b0）](https://www.jianshu.com/p/3f20ca1a93b0)

#### 实现步骤：
```
    · 导入相关MapStruct依赖
        <dependency>
            <groupId>org.mapstruct</groupId>
            <artifactId>mapstruct-jdk8</artifactId>
            <version>1.2.0.Final</version>
        </dependency>
        <dependency>
            <groupId>org.mapstruct</groupId>
            <artifactId>mapstruct-processor</artifactId>
            <version>1.2.0.Final</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>javax.inject</groupId>
            <artifactId>javax.inject</artifactId>
            <version>1</version>
        </dependency>
    · 创建相应实体类和dao
        eg：
            {@link GoodInfos}
            {@link GoodTypes}
            {@link GoodTypesDao}
            {@link GoodTypesDao}
    · 创建DTO实体类
        eg:
            {@link GoodDTO}
    · 创建DTO相应的mapper
        eg：
            {@link GoodDtoMapper}
    · 使用方式
        eg: 
            1.默认方式配置
                //Mapper接口内部定义
                public static GoodInfoMapper MAPPER = Mappers.getMapper(GoodInfoMapper.class);
                //外部调用
                GoodInfoMapper.MAPPER.from(goodBean,goodTypeBean);
            2.spring方式配置
                Spring方式我们需要在@Mapper注解内添加componentModel属性值，配置后在外部可以采用@Autowired方式注入Mapper实现类完成映射方法调用。
                //注解配置
                @Mapper(componentModel = "spring")
                //注入Mapper实现类
                @Autowired
                private GoodInfoMapper goodInfoMapper;
                //调用
                goodInfoMapper.from(goodBean,goodTypeBean);
```