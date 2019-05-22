package cn.yanwin.demo.service.impl;

import cn.yanwin.demo.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


/**
 * @author:YanWei
 * @date: 2019/5/21 15:56
 * @desc: 实现类
 */
@Service
public class AsyncServiceImpl {
    public static final Logger LOGGER = LoggerFactory.getLogger(AsyncServiceImpl.class);
    @Async("asyncServiceExecutor")
    public void executeAsync() {
        LOGGER.info("start executeAsync");
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        LOGGER.info("end executeAsync");
    }
}
