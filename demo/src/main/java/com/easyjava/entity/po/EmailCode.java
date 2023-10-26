package com.easyjava.entity.po;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * @description: 
 * @author: ricardo.m.lu
 * @date: 23-10-24
 */
public class EmailCode implements Serializable {
	/**
 	 * 邮箱
 	 */
	private String email;

	/**
 	 * 验证码
 	 */
	private String code;

	/**
 	 * 验证码创建时间
 	 */
	@JsonFormat(pattern = "yy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
 	 * 状态0：未使用1:已使用
 	 */
	private Integer status;

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return this.status;
	}

}