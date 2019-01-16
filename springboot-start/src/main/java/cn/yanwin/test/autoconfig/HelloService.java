/**
* @Company JBINFO   
* @Title: HelloService.java 
* @Package cn.yanwin.test.autoconfig 
* @author Yan Wei   
* @date 2018年3月1日 下午8:14:52 
* @version V1.0   
*/ 
package cn.yanwin.test.autoconfig;

/** 
* @ClassName: HelloService 
* @Description: 我们为自定义starter提供一个Service，并且提供一个名为sayHello的方法用于返回我们配置的msg内容。
* @author Yan Wei  
*/
public class HelloService
{
    //消息内容
    private String msg;
    //是否显示消息内容
    private boolean show = false;

    public String sayHello()
    {
        return show ? "Hello，" + msg : "Hidden";
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}

