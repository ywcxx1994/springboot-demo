package cn.yanwin.demo.extend;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author:YanWei
 * @date: 2019/5/13 14:13
 * @desc: bean生成前后做操作
 */
@Component
public class BeanPostProcessorDemo implements BeanPostProcessor {
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
}
