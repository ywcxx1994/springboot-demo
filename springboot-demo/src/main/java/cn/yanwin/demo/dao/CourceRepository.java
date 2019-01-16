/**
* @Company JBINFO   
* @Title: CourceRepository.java 
* @Package cn.yanwin.demo.dao 
* @author Yan Wei   
* @date 2018年6月3日 上午10:33:13 
* @version V1.0   
*/ 
package cn.yanwin.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.yanwin.demo.domain.Course;

/** 
* @ClassName: CourceRepository 
* @Description: dao 
* @author Yan Wei  
*/
public interface CourceRepository extends JpaRepository<Course, String>{
	
}
