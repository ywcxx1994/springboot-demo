/**
* @Company JBINFO   
* @Title: Myexception.java 
* @Package cn.yanwin.demo.exception 
* @author Yan Wei   
* @date 2018年3月2日 下午1:54:58 
* @version V1.0   
*/ 
package cn.yanwin.demo.exception;

/** 
* @ClassName: Myexception 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Yan Wei  
*/

public class MyException extends RuntimeException{
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -4250689318175690568L;
	private String code;
	private String msg;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public MyException(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
}
