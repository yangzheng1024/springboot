package com.example.demo;

import com.example.demo.utils.IdGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
        IdGenerator idGenerator = new IdGenerator(5, 6, 7);
        long l = idGenerator.nextId();
        System.out.println();
        System.out.printf("你好 %s  userId %d", "杨正", l);
    }

}

