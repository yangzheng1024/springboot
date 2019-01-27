package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    /**
     * 测试生成主键
     */
    @Test
    public void contextLoads() {
//        IdGenerator idGenerator = new IdGenerator(5, 6, 7);
//        long l = idGenerator.nextId();
//        System.out.println();
//        System.out.printf("你好 %s  userId %d", "杨正", l);
    }

    /**
     * 利用md5进行加密
     */
    @Test
    public void md5Test(){
        try {
            String str = "963258";
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            byte[] digest = md5.digest(str.getBytes("utf-8"));
            String encode = base64Encoder.encode(digest);
            System.out.println(encode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

