/**
* @Company JBINFO   
* @Title: MyConfiguration.java 
* @Package cn.yanwin.demo 
* @author Yan Wei   
* @date 2018年5月10日 下午9:15:55 
* @version V1.0   
*/ 
package cn.yanwin.demo.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.yanwin.demo.web.filter.DemoFilter;
import cn.yanwin.demo.web.interceptor.DemoInterceptor;
import cn.yanwin.test.argument.YanweiArgument;

/** 
* @ClassName: MyConfiguration 
* @Description: 配置类
* @author Yan Wei  
*/
@Configuration
public class MyConfiguration extends WebMvcConfigurerAdapter{
	@Autowired
	private DemoInterceptor interceptor;

	@Autowired
	private DemoFilter demoFilter;
	/**
	 * 
	 * @description 
	 * spring data提供默认redistemplate使用jdk的序列化机制，存进去是二进制的字节码，
	 * 对象必须实现Serializable接口，使用
	 * Jackson2JsonRedisSerializer，将存的对象转成json存储。
	   @Date:2019年3月5日上午9:10:32
	 */
	@Bean
	@ConditionalOnMissingBean(RedisTemplate.class)
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory){
		RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
		template.setConnectionFactory(connectionFactory);
		//使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
	    Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer(Object.class);
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
	    mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
	    serializer.setObjectMapper(mapper);
	    template.setValueSerializer(serializer);
	    //使用StringRedisSerializer来序列化和反序列化redis的key值
	    template.setKeySerializer(new StringRedisSerializer());
	    template.afterPropertiesSet();
	    return template;
	}
	/**
	 * 
	* @Description: 注册FilterRegistrationBean
	* @author Yan Wei   
	* @date 2018年5月10日 下午9:19:10 
	* @return
	 */
	@Bean
	public FilterRegistrationBean registyBean() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		//拦截那些路径
		bean.setUrlPatterns(Arrays.asList("/*"));
		//添加到过滤器中
		bean.setFilter(demoFilter);
		return bean;
	}
	/**
	 * 
	* <p>Description:将拦截器添加到这里，就能生效 </p> 
	* @author Yan Wei   
	* @date 2018年5月10日 下午9:36:41 
	* @param registry 
	* @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor).excludePathPatterns("/hello");
		super.addInterceptors(registry);
	}
	/**
	 * 添加自定义参数解析器
	 */
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new YanweiArgument());
	}
	
}
