/**
* @Company JBINFO   
* @Title: HelloController.java 
* @Package cn.yanwin.demo.controller 
* @author Yan Wei   
* @date 2018年3月2日 上午9:22:52 
* @version V1.0   
*/ 
package cn.yanwin.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
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
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
@RestController
public class HelloController {
	//注入自定义starter内逻辑
    @Autowired
    private HelloService helloService;
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    @Autowired
    private StringRedisTemplate redisTemplate;
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
    /**
     * 
    * @Description: redis存储(String)
    * @author Yan Wei   
    * @date 2018年6月3日 上午9:23:32 
    * @param key
    * @param value
    * @return
     */
    @RequestMapping(value="setRedis/{key}/{value}")
    public String setRedis(@PathVariable String key,@PathVariable String value) {
    	redisTemplate.opsForValue().set(key, value);
    	//设置redis的过期时间
//    	redisTemplate.expire(key, 10, TimeUnit.SECONDS);
    	return "save success";
    }
    /**
     * 
    * @Description: 根据key，获取value
    * @author Yan Wei   
    * @date 2018年6月3日 上午9:23:57 
    * @param key
    * @return
     */
    @RequestMapping(value="getRedis/{key}")
    public String getRedis(@PathVariable String key) {
    	return redisTemplate.opsForValue().get(key);
    }
    
    @RequestMapping(value="testArgument")
    public String testArgument(@Yanwei String key) {
    	return key;
    }
}
