/**
* @Company JBINFO   
* @Title: ExceptionAdvice.java 
* @Package cn.yanwin.demo.exception 
* @author Yan Wei   
* @date 2018年3月2日 下午1:58:32 
* @version V1.0   
*/ 
package cn.yanwin.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/** 
* @ClassName: ExceptionAdvice 
* @Description: 全局统一异常处理
* @author Yan Wei  
*/
@RestControllerAdvice
public class ExceptionAdvice {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(MyException.class)
	public Map<String, String> globalException(MyException exception){
		Map map = new HashMap();
        map.put("code", exception.getCode());
        map.put("msg", exception.getMsg());
        return map;
	}
}
