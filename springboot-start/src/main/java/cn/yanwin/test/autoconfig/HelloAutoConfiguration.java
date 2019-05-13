/**
* @Company JBINFO   
* @Title: HelloAutoConfiguration.java 
* @Package cn.yanwin.test.autoconfig 
* @author Yan Wei   
* @date 2018年3月1日 下午8:16:15 
* @version V1.0   
*/ 
package cn.yanwin.test.autoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.yanwin.test.aop.ControllerLogAspect;

/** 
* @ClassName: HelloAutoConfiguration 
* @Description: 自动配置
* @author Yan Wei  
*/
@Configuration//开启配置
@EnableConfigurationProperties(HelloProperties.class)//开启使用映射实体对象
public class HelloAutoConfiguration {
	//application.yml配置文件映射前缀实体对象
 	@Autowired
    private HelloProperties helloProperties;
 	
    @Bean//创建HelloService实体bean
    @ConditionalOnMissingBean(HelloService.class)//缺失HelloService实体bean时，初始化HelloService并添加到SpringIoc)
    @ConditionalOnProperty( prefix = "hello", value = "enabled", matchIfMissing = true)
    public HelloService createBean(){
        System.out.println(">>>The HelloService Not Found，Execute Create New Bean.");
        HelloService helloService = new HelloService();
        helloService.setMsg(helloProperties.getMsg());//设置消息内容
        helloService.setShow(helloProperties.isShow());//设置是否显示
        return helloService;
    }
    @Bean
    @ConditionalOnProperty(prefix = "enableAop",name = "storeMongo",havingValue="true")
    public ControllerLogAspect logBean() {
    	System.out.println(">>>enable ControllerLogAspect to store log");
    	return new ControllerLogAspect();
    }
}
