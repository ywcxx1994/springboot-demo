/**
* @Company JBINFO   
* @Title: CourseService.java 
* @Package cn.yanwin.demo.service 
* @author Yan Wei   
* @date 2018年6月3日 上午10:43:43 
* @version V1.0   
*/ 
package cn.yanwin.demo.service;

import java.util.List;

import cn.yanwin.demo.domain.Course;

/** 
* @ClassName: CourseService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/

public interface CourseService {
	
	List<Course> getAll();
	
	
	Course findById(String id);
	
	Course save(Course course);
	
	String delete(String id);
}
