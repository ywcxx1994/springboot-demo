package cn.yanwin.demo.extend;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @author: yanwin
 * @Date: 2020/1/20
 */
@Configuration
public class MyBeanFactoryPostProcessorDemo implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("beanDemo");
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        if(propertyValues.contains("id")){
            propertyValues.add("id","26");
        }
    }
}
