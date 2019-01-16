/**
* @Company JBINFO   
* @Title: HelloProperties.java 
* @Package cn.yanwin.test.prop 
* @author Yan Wei   
* @date 2018年3月1日 下午8:09:04 
* @version V1.0   
*/ 
package cn.yanwin.test.autoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

/** 
* @ClassName: HelloProperties 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
@ConfigurationProperties(prefix="hello")
public class HelloProperties {
	private String msg = "HelloProperties";
	private boolean show = true;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isShow() {
		return show;
	}
	public void setShow(boolean show) {
		this.show = show;
	}
}
