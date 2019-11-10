package cn.yanwin.test.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by 18765 on 2019/11/10 11:03
 */
public class CacheUtils {
    private static final Map<String,Object> CACHE = new ConcurrentHashMap<>();

    private static final ScheduledExecutorService SCHEDULED_EXECUTOR_SERVICE =
            new ScheduledThreadPoolExecutor(2);

    public static void put(String key,Object value,long expire){
        if(expire > 0){
            SCHEDULED_EXECUTOR_SERVICE.schedule(() -> {
               CacheUtils.remove(key);
            }, expire, TimeUnit.SECONDS);
        }
        CACHE.put(key,value);
    }
    public static void put(String key,Object value){
        CacheUtils.put(key,value,0);
    }

    public static void remove(String key){
        if(CACHE.containsKey(key)){
            CACHE.remove(key);
        }
    }

    public static Object get(String key){
        return CACHE.get(key);
    }

    public static void main(String[] args) throws InterruptedException {
        CacheUtils.put("y","w",2);
        System.out.println(CacheUtils.get("y"));
        Thread.sleep(2000);
        System.out.println(CacheUtils.get("y"));
    }
}
