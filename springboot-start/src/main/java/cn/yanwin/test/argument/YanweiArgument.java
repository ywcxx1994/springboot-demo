package cn.yanwin.test.argument;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import cn.yanwin.test.anno.Yanwei;
public class YanweiArgument implements HandlerMethodArgumentResolver{
	
	public YanweiArgument() {
		System.out.println("YanweiArgument is init");
	}

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		//参数上是否有这个注解，返回true则使用该解析器，反之亦然
		return parameter.hasParameterAnnotation(Yanwei.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		return "123";
	}

}
