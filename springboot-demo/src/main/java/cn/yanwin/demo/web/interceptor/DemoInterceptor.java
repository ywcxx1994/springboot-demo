/**
* @Company JBINFO   
* @Title: DemoInterceptor.java 
* @Package cn.yanwin.demo.web.interceptor 
* @author Yan Wei   
* @date 2018年5月10日 下午9:25:44 
* @version V1.0   
*/ 
package cn.yanwin.demo.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/** 
* @ClassName: DemoInterceptor 
* @Description: 拦截器的使用例子 .可以获取到执行的handler对象，http请求对象，
* 获取不到方法的参数对象，aspect可以获取到方法参数对象，handler对象，但是获取不到http请求对象
* 
* @author Yan Wei  
*/
@Component
public class DemoInterceptor implements HandlerInterceptor{

	/**
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2018年5月10日 下午9:28:43 
	* @param request
	* @param response
	* @param handler
	* @return
	* @throws Exception 
	* @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object) 
	*/ 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//return false，不会执行handler的方法
		System.out.println("interceptor preHandle");
		return true;
	}

	/**
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2018年5月10日 下午9:28:43 
	* @param request
	* @param response
	* @param handler
	* @param modelAndView
	* @throws Exception 
	* @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView) 
	*/ 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//这个方法handler中出现异常，不会执行这个方法
		System.out.println("interceptor postHandle to do something");
	}

	/**
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2018年5月10日 下午9:28:43 
	* @param request
	* @param response
	* @param handler
	* @param ex
	* @throws Exception 
	* @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception) 
	*/ 
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//ex这个异常@controllerAdvice没有处理，才会拦截到
		//无论handler是否异常，都会走这个方法
		System.out.println("interceptor afterCompletion");
	}

}
