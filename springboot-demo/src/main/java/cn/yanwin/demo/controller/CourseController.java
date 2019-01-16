/**
 * @Company JBINFO   
* @Title: CourseController.java 
* @Package cn.yanwin.demo.controller 
* @author Yan Wei   
* @date 2018年6月3日 上午10:46:02 
* @version V1.0   
*/ 
package cn.yanwin.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yanwin.demo.domain.Course;
import cn.yanwin.demo.service.CourseService;

/** 
* @ClassName: CourseController 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
@RestController
@RequestMapping("course")
public class CourseController {
	@Autowired 
	private CourseService courseService;
	
	@RequestMapping("getA")
	public List<Course> getAll(){
		return courseService.getAll();
	}
	@RequestMapping("getOne/{id}")
	public Course getOne(@PathVariable String id){
		return courseService.findById(id);
	}
	@RequestMapping("save")
	public Course save(@RequestBody Course course){
		return courseService.save(course);
	}
	
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable String id){
		return courseService.delete(id);
	}
}
