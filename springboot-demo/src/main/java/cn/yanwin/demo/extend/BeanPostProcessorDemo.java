package cn.yanwin.demo.extend;

import cn.yanwin.demo.service.AsyncService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

/**
 * @author:YanWei
 * @date: 2019/5/13 14:13
 * @desc: bean生成前后做操作
 */
@Component
public class BeanPostProcessorDemo implements BeanPostProcessor {
    @Autowired
    private AsyncService asyncService;
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        //System.out.println("enter before" + o.getClass().getSimpleName());
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        //System.out.println("enter after");
        return o;
    }


//    @Override
//    public int getOrder() {
//        return Ordered.LOWEST_PRECEDENCE;
//    }
}
