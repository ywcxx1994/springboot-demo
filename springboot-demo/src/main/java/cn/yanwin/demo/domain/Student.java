/**
* @Company JBINFO   
* @Title: Student.java 
* @Package cn.yanwin.demo.domain 
* @author Yan Wei   
* @date 2018年4月20日 下午3:47:28 
* @version V1.0   
*/ 
package cn.yanwin.demo.domain;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
* @ClassName: Student 
* @Description: 
* @author Yan Wei  
*/
@Builder
@Data
@NoArgsConstructor
public class Student implements Serializable{
	private static final long serialVersionUID = -7060365644988194845L;
	private String name;
	private Integer age;
	private String lover;
	
	public Student(String name, Integer age, String lover) {
		super();
		this.name = name;
		this.age = age;
		this.lover = lover;
	}
	
}
