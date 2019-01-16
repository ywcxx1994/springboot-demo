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

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/** 
* @ClassName: ApiDTO 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/
@Data
@Document(collection="apiLog")
public class ApiLogDTO {

	/** 
	* <p>Description: </p> 
	* @author Yan Wei   
	* @date 2018年4月23日 下午2:48:54  
	*/ 
	public ApiLogDTO() {
	}
	@Id
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getHttpMethod() {
		return httpMethod;
	}
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getClassMethod() {
		return classMethod;
	}
	public void setClassMethod(String classMethod) {
		this.classMethod = classMethod;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public String getReturnResult() {
		return returnResult;
	}
	public void setReturnResult(String returnResult) {
		this.returnResult = returnResult;
	}
	public String getArgs() {
		return args;
	}
	public void setArgs(String args) {
		this.args = args;
	}
	
}
