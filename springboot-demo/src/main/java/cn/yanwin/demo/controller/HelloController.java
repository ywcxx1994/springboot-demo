/**
* @Company JBINFO   
* @Title: HelloController.java 
* @Package cn.yanwin.demo.controller 
* @author Yan Wei   
* @date 2018年3月2日 上午9:22:52 
* @version V1.0   
*/ 
package cn.yanwin.demo.controller;

import cn.yanwin.demo.service.impl.AsyncServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

import cn.yanwin.demo.domain.Student;
import cn.yanwin.demo.exception.MyException;
import cn.yanwin.test.anno.Yanwei;
import cn.yanwin.test.autoconfig.HelloService;

/** 
* @ClassName: HelloController 
* @Description: demo的控制器
* @author Yan Wei  
*/
@RestController
@Slf4j
public class HelloController {
    @Autowired
    private HelloService helloService;
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    @Autowired
    AsyncServiceImpl asyncService;
    /**
     * 测试访问地址/hello
     * @return 格式化字符串
     */
    @RequestMapping(value = "/hello")
    public String sayHello(){
        return helloService.sayHello();
    }
    
    /**
     * 
    * @Description:异常处理
    * @author Yan Wei   
    * @date 2018年3月2日 下午2:03:01 
    * @return
     */
    @RequestMapping(value = "/exception")
    public void exception() {
    	throw new MyException("100","请求异常 ！！");
    }
    /**
     * 
    * @Description: mongo存储
    * @author Yan Wei   
    * @date 2018年6月3日 上午9:24:27
     */
    @RequestMapping(value = "/mongoSave")
    public void mongoSave() {
    	mongoTemplate.save(new Student("yanchang", 12, "放屁"));
    }
    /**
     * 
    * @Description:redis操作mongodb,取
    * @author Yan Wei   
    * @date 2018年6月3日 上午9:24:12 
    * @return
     */
    @RequestMapping(value = "/mongoGet")
    public DBObject mongoGet() {
    	DBCollection collection = mongoTemplate.getCollection("student");
    	BasicDBObject queryDefaultObj = new BasicDBObject();
    	queryDefaultObj.append("name", "yanchang");
    	return collection.findOne(queryDefaultObj);
    }
   
   
    @RequestMapping(value="testArgument")
    public String testArgument(@Yanwei String key) {
    	return key;
    }

    @RequestMapping("testThreadPool")
    public String testThreadPool(){
        log.info("start submit");
        //调用service层的任务
        asyncService.executeAsync();
        log.info("end submit");
        return "success";
    }
}
