package cn.yanwin.demo.controller;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
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

    
    @RequestMapping(value="getRedisByKey/{key}")
    public Object getRedisByKey(@PathVariable String key) {
    	return redisTemplate.opsForList().leftPop(key);
    }

    @RequestMapping(value="setRedisSet/{key}")
    public Object setRedisSet(@PathVariable String key) {
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        SetOperations set = redisTemplate.opsForSet();
        set.add(key,"22");
        set.add(key,"22");
        set.add(key,"33");
        set.add(key,"44");
        return set.members(key);
    }

    @RequestMapping(value="setRedisMap/{key}")
    public Object setRedisMap(@PathVariable String key) {
        HashOperations hashOperations = redisTemplate.opsForHash();
        Map<String,String> map=new HashMap<String,String>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");
        map.put("key5","value5");

        hashOperations.putAll(key,map);
        //获取整个map
        Map entries = hashOperations.entries(key);
        //获取所有key
        Set keys = hashOperations.keys(key);
        return keys.toArray();
    }
}
