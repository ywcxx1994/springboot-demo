package cn.yanwin.demo.extend;

import cn.yanwin.test.autoconfig.HelloService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by 18765 on 2020/1/5 21:31
 */
@Component
public class MyBean implements InitializingBean {

    @Autowired
    private HelloService helloService;

    public void init(){
        System.out.println("init invoke"+helloService);
    }
    public MyBean() {
        System.out.println("MyBean"+helloService);
//        System.out.println("MyBean Construtor invoke");
    }
    @PostConstruct
    public void postContrutor(){
        System.out.println("postContrutor:"+helloService);
//        System.out.println("post invoke ");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet:"+helloService);
    }

    public void setHelloService(HelloService helloService) {
        System.out.println("by this method inject helloService");
        this.helloService = helloService;
    }
}
