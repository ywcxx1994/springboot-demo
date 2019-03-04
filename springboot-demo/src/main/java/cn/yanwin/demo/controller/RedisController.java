package cn.yanwin.demo.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yanwin.demo.domain.Student;

@RestController
@RequestMapping("redis")
public class RedisController {
	@Autowired
	private RedisTemplate redisTemplate;
	 /**
     * 
    * @Description: redis存储(String)
    * @author Yan Wei   
    * @date 2018年6月3日 上午9:23:32 
    * @param key
    * @param value
    * @return
     */
    @SuppressWarnings("unchecked")
	@RequestMapping(value="setRedis/{key}/{value}")
    public String setRedis(@PathVariable String key,@PathVariable String value) {
    	redisTemplate.opsForValue().set(key, value);
    	//设置redis的过期时间
    	redisTemplate.expire(key, 10, TimeUnit.SECONDS);
    	return "save success";
    }
    /**
     	* 存对象
     * @description
       @Date:2019年3月4日上午11:26:01
     */
    @RequestMapping(value="setRedisObj/{key}/{value}")
    @SuppressWarnings("unchecked")
    public String setRedisObj(@PathVariable String key,@PathVariable String value) {
    	
    	Student stu1 = new Student(key, 12, value);
    	Student stu2 = new Student(key, 12, value);
    	redisTemplate.opsForList().leftPush(key, Arrays.asList(stu1,stu2));
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
    	return (String)redisTemplate.opsForValue().get(key);
    }
    
    @RequestMapping(value="getRedisByKey/{key}")
    public Object getRedisByKey(@PathVariable String key) {
    	return (List<Student>)redisTemplate.opsForList().leftPop("stu2");
    }
    
}
