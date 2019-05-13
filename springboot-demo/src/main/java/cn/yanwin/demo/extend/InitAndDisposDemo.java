package cn.yanwin.demo.extend;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author:YanWei
 * @date: 2019/5/13 13:23
 * @desc: bean的属性加载完和bean生命周期结束后的demo
 */
@Component
public class InitAndDisposDemo implements InitializingBean, DisposableBean {
    @Value("${lifeCycle}")
    private String lifeCycle;

    public void setLifeCycle(String lifeCycle) {
        System.out.println("Enter LifecycleBean.setLifeCycleBeanName()"+lifeCycle);
        this.lifeCycle = lifeCycle;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(" enter destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(" enter afterPropertiesSet");
    }
}
