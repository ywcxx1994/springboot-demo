package cn.yanwin.demo.controller;

import cn.yanwin.demo.exception.MyException;
import cn.yanwin.test.anno.Access;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试bean的单例,@Scope("prototype")让spring的bean不在是单例。
 */
@RequestMapping("bean")
@RestController
@Scope("prototype")
public class BeanLifeController {
    private int i = 0;
    /**
     * 静态变量所有对象共享
     */
    private static int a;

    @RequestMapping("test1")
    @Access(second = 5,count = 5)
    public int  test1(){
        return ++i;
    }
    @RequestMapping("test2")
    public int  test2(){
        return ++i;
    }
    @RequestMapping("test3")
    public int  test3(){
        if(a == 1){
            throw new MyException("1002","全局异常拦截");
        }
        return ++a;
    }
    @RequestMapping("test4")
    public int  test4(){
        return ++a;
    }
}
