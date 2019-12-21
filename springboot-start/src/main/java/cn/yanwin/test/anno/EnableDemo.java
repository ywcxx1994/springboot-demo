package cn.yanwin.test.anno;

import cn.yanwin.test.autoconfig.TestEnableAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 18765 on 2019/12/20 17:29
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//@Import(TestEnableAutoConfiguration.class)
public @interface EnableDemo {

}
