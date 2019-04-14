package cn.yanwin.demo.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试bean的单例,@Scope("prototype")让spring的bean不在是单例。
 */
@RequestMapping("bean")
@RestController
@Scope("prototype")
public class BeanLifeDemo {
    private int i = 0;
    private static int a = 0;
    @RequestMapping("test1")
    public int  test1(){
        return ++i;
    }
    @RequestMapping("test2")
    public int  test2(){
        return ++i;
    }
    @RequestMapping("test3")
    public int  test3(){
        return ++a;
    }
    @RequestMapping("test4")
    public int  test4(){
        return ++a;
    }
}
