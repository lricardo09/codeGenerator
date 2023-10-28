package com.easyjava.entity.query;


import java.util.Date;
/**
 * @description: 
 * @author: ricardo.m.lu
 * @date: 23-10-28
 */
public class EmailCodeQuery extends BaseQuery {
	/**
 	 * 邮箱
 	 */
	private String email;
	private String emailFuzzy;
	/**
 	 * 验证码
 	 */
	private String code;
	private String codeFuzzy;
	/**
 	 * 验证码创建时间
 	 */
	private Date createTime;
	private String createTimeStart;
	private String createTimeEnd;
	/**
 	 * 状态0：未使用1:已使用
 	 */
	private Integer status;

	/**
 	 * 
 	 */
	private Integer id;

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

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return this.id;
	}

	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public String getCreateTimeStart() {
		return this.createTimeStart;
	}
	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public String getCreateTimeEnd() {
		return this.createTimeEnd;
	}

	public void setEmailFuzzy(String emailFuzzy) {
		this.emailFuzzy = emailFuzzy;
	}

	public String getEmailFuzzy() {
		return this.emailFuzzy;
	}
	public void setCodeFuzzy(String codeFuzzy) {
		this.codeFuzzy = codeFuzzy;
	}

	public String getCodeFuzzy() {
		return this.codeFuzzy;
	}
}