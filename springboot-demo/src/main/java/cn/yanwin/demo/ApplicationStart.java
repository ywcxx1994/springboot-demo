/**
* @Company JBINFO   
* @Title: ApplicationStart.java 
* @Package cn.yanwin.start 
* @author Yan Wei   
* @date 2018年3月1日 下午8:50:24 
* @version V1.0   
*/ 
package cn.yanwin.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/** 
* @ClassName: ApplicationStart 
* @Description: 应用的入口   
* @author Yan Wei  
*/
@SpringBootApplication(scanBasePackages={"cn.yanwin.test","cn.yanwin.demo"})
@EnableCaching
public class ApplicationStart {
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationStart.class, args);
	}
}
