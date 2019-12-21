package cn.yanwin.demo;

import cn.yanwin.test.anno.EnableDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;

/**
 * Created by 18765 on 2019/12/20 17:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableDemo
public class ApplicationTest {
    @Autowired
    ApplicationContext applicationContext;
    @Test
    public void contextLoads()  {
//        Stream.of( applicationContext.getBeanDefinitionNames()).forEach((str)-> System.out.println(str));
    }
}
