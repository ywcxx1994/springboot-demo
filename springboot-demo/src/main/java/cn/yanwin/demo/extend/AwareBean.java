package cn.yanwin.demo.extend;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author:YanWei
 * @date: 2019/5/13 13:40
 * @desc: 带有感知的bean接口
 */
@Component
public class AwareBean implements BeanNameAware, ApplicationContextAware, BeanFactoryAware {
    private String beanName;
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    /**
     * 获取加载该bean的工厂类
     * * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Enter AwareBean.setBeanFactory(), beanfactory = " + beanFactory + "\n");
        this.beanFactory = beanFactory;
    }

    /**
     * 获取bean在容器中的名字。
     * @param beanName
     */
    @Override
    public void setBeanName(String beanName) {
        System.out.println("Enter AwareBean.setBeanName(), beanName = " + beanName + "\n");
        this.beanName = beanName;
    }

    /**
     * 获取spring应用的上下文
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Enter AwareBean.setApplicationContext(), applicationContext = " + applicationContext + "\n");
        this.applicationContext =  applicationContext;
    }
}
