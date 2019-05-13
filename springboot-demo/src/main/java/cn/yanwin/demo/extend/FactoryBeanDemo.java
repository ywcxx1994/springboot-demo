package cn.yanwin.demo.extend;

import cn.yanwin.demo.domain.Student;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author:YanWei
 * @date: 2019/5/13 13:51
 * @desc: 控制bean的实例化过程，自己掌握bean实例化的主动权
 */
@Component
public class FactoryBeanDemo implements FactoryBean<Student> {
    /**
     * 控制bean的实例化过程
     * @return
     * @throws Exception
     */
    @Override
    public Student getObject() throws Exception {
        return new Student();
    }

    /**
     * 获取bean的类类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }

    /**
     * 是否单例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
