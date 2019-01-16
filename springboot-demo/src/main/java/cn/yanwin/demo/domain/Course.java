/**
* @Company JBINFO   
* @Title: Course.java 
* @Package cn.yanwin.demo.domain 
* @author Yan Wei   
* @date 2018年6月3日 上午10:30:18 
* @version V1.0   
*/ 
package cn.yanwin.demo.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

/** 
* @ClassName: Course 
* @Description:实体类 
* @author Yan Wei  
*/
@Entity
@Data
@Table(name="courses")
public class Course implements Serializable{
	/** 
	*/ 
	private static final long serialVersionUID = 2447223020103133587L;

	@Id  
    private String courseno; 
	
	private String coursenm;

	public Course() {
		
	}
	
}
