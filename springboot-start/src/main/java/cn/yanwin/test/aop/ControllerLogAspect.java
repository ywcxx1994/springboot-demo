/**
* @Company JBINFO   
* @Title: ControllerLogAspect.java 
* @Package cn.yanwin.test.aop 
* @author Yan Wei   
* @date 2018年4月23日 下午2:05:00 
* @version V1.0   
*/ 
package cn.yanwin.test.aop;

import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/** 
* @ClassName: ControllerLogAspect 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
@Aspect
public class ControllerLogAspect {
	@Autowired
	private MongoTemplate mongoTemplate;
	//切入点
	@Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
	public void controllerAspect() {}
	//通知
	@Around("controllerAspect()")
	public Object aroundControllerAdvice(ProceedingJoinPoint pjp) throws Throwable {
		Object result = null;
		Signature signature = pjp.getSignature();
		//通过RequestContextHolder获取HttpServletResquest对象
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		//创建dto
		final ApiLogDTO apiLog=new ApiLogDTO();
		apiLog.setIp(request.getRemoteHost());
		apiLog.setHttpMethod(request.getMethod());
		apiLog.setClassMethod(signature.getDeclaringTypeName() + "." + signature.getName());
		apiLog.setArgs(String.valueOf(Arrays.asList(pjp.getArgs())));
		apiLog.setDateTime(new Date());
		apiLog.setUrl(String.valueOf(request.getRequestURI()));
		result = pjp.proceed();
		apiLog.setReturnResult(result.toString());
		ExecutorService es = Executors.newFixedThreadPool(10);
		try {
			//开启线程，执行日志操作
			es.execute(()->{
				mongoTemplate.insert(apiLog);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}
