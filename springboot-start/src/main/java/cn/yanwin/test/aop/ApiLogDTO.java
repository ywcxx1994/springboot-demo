/**
* @Company JBINFO   
* @Title: ApiDTO.java 
* @Package cn.yanwin.test.aop 
* @author Yan Wei   
* @date 2018年4月23日 下午2:13:32 
* @version V1.0   
*/ 
package cn.yanwin.test.aop;

import java.util.Date;


import lombok.Data;

/** 
* @ClassName: ApiDTO 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
@Data
//@Document(collection="apiLog")
public class ApiLogDTO {

	/** 
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2018年4月23日 下午2:48:54  
	*/ 
	public ApiLogDTO() {
	}
	private String id;
	private String url;
	private String userName;
	private String userId;
	private String httpMethod;
	private String ip;
	private String classMethod;
	private String args;
	private String parameter;
	private Date dateTime;
	private String returnResult;

	
}
