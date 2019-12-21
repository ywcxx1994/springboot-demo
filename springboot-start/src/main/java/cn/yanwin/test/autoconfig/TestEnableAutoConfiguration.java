package cn.yanwin.test.autoconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 18765 on 2019/12/20 17:27
 */
@Configuration//开启配置
public class TestEnableAutoConfiguration {
    @Bean
    public Student student(){
        System.out.println("enable 生效");
        return new Student();
    }
}
