/**
* @Company JBINFO   
* @Title: DemoFilter.java 
* @Package cn.yanwin.demo.web.filter 
* @author Yan Wei   
* @date 2018年5月10日 下午9:09:37 
* @version V1.0   
*/ 
package cn.yanwin.demo.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/** 
* @ClassName: DemoFilter 
* @Description:第一个过滤器组件
* 	可以注册为spring的组件@Component
*/

public class DemoFilter implements Filter{

	/**
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2018年5月10日 下午9:12:02  
	* @see javax.servlet.Filter#destroy() 
	*/ 
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/**
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2018年5月10日 下午9:12:02 
	* @param arg0
	* @param arg1
	* @param arg2
	* @throws IOException
	* @throws ServletException 
	* @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain) 
	*/ 
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain china)
			throws IOException, ServletException {
		System.out.println("demofilter filter begin");
		//放行
		china.doFilter(arg0, arg1);
		System.out.println("demofilter filter end");
	}

	/**
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2018年5月10日 下午9:12:02 
	* @param arg0
	* @throws ServletException 
	* @see javax.servlet.Filter#init(javax.servlet.FilterConfig) 
	*/ 
	@Override
	public void init(FilterConfig china) throws ServletException {
		System.out.println("DemoFilter init");
	}
}
