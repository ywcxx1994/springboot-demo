/**
* @Company JBINFO   
* @Title: CourseServiceImpl.java 
* @Package cn.yanwin.demo.service 
* @author Yan Wei   
* @date 2018年6月3日 上午10:49:58 
* @version V1.0   
*/ 
package cn.yanwin.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cn.yanwin.demo.dao.CourceRepository;
import cn.yanwin.demo.domain.Course;
import cn.yanwin.demo.service.CourseService;

/** 
* @ClassName: CourseServiceImpl 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
@Service
@CacheConfig(cacheNames="course")
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourceRepository courceRepository;

	/**
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2018年6月3日 上午10:51:43 
	* @return 
	* @see cn.yanwin.demo.service.CourseService#getAll() 
	*/ 
	@Override
	public List<Course> getAll() {
		return courceRepository.findAll();
	}

	/**
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2018年6月3日 上午11:11:22 
	* @param id
	* @return 
	* @see cn.yanwin.demo.service.CourseService#findById(java.lang.String) 
	*/ 
	@Override
	@Cacheable(key = "#p0")
	public Course findById(String id) {
		return courceRepository.findOne(id);
	}

	/**
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2018年6月3日 下午12:09:29 
	* @param course
	* @return 
	* @see cn.yanwin.demo.service.CourseService#save(cn.yanwin.demo.domain.Course) 
	*/ 
	@Override
	@CachePut(key="#p0.courseno")
	public Course save(Course course) {
		courceRepository.save(course);
		return course;
	}

	/**
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2018年6月3日 下午12:09:29 
	* @param id
	* @return 
	* @see cn.yanwin.demo.service.CourseService#delete(java.lang.String) 
	*/ 
	@Override
	@CacheEvict(key="#p0")
	public String delete(String id) {
		courceRepository.delete(id);
		return id;
	}
	
	
}
