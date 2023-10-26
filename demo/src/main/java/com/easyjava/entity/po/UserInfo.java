package com.easyjava.entity.po;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * @description: 用户信息
 * @author: ricardo.m.lu
 * @date: 23-10-24
 */
public class UserInfo implements Serializable {
	/**
 	 * 用户id
 	 */
	@JsonIgnore
	private String userId;

	/**
 	 * 昵称
 	 */
	private String nickName;

	/**
 	 * 邮箱
 	 */
	private String email;

	/**
 	 * qq open id
 	 */
	private String qqOpenId;

	/**
 	 * qq头像
 	 */
	private String qqAvatar;

	/**
 	 * 密码
 	 */
	private String password;

	/**
 	 * 注册时间
 	 */
	@JsonFormat(pattern = "yy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yy-MM-dd HH:mm:ss")
	private Date joinTime;

	/**
 	 * 上次登录时间
 	 */
	@JsonFormat(pattern = "yy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yy-MM-dd HH:mm:ss")
	private Date lastLoginTime;

	/**
 	 * 1:启用 0：禁用
 	 */
	private Integer status;

	/**
 	 * 可用空间
 	 */
	private Long useSpace;

	/**
 	 * 总空间
 	 */
	private Long totalSpace;

	/**
 	 * 联合主键1
 	 */
	private Integer t1;

	/**
 	 * 联合主键2
 	 */
	private Integer t2;

	/**
 	 * 日期类字段,不带时分秒
 	 */
	@JsonFormat(pattern = "yy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yy-MM-dd")
	private Date joinDateTest;

	/**
 	 * 钱
 	 */
	private BigDecimal money;

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setQqOpenId(String qqOpenId) {
		this.qqOpenId = qqOpenId;
	}

	public String getQqOpenId() {
		return this.qqOpenId;
	}

	public void setQqAvatar(String qqAvatar) {
		this.qqAvatar = qqAvatar;
	}

	public String getQqAvatar() {
		return this.qqAvatar;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

	public Date getJoinTime() {
		return this.joinTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setUseSpace(Long useSpace) {
		this.useSpace = useSpace;
	}

	public Long getUseSpace() {
		return this.useSpace;
	}

	public void setTotalSpace(Long totalSpace) {
		this.totalSpace = totalSpace;
	}

	public Long getTotalSpace() {
		return this.totalSpace;
	}

	public void setT1(Integer t1) {
		this.t1 = t1;
	}

	public Integer getT1() {
		return this.t1;
	}

	public void setT2(Integer t2) {
		this.t2 = t2;
	}

	public Integer getT2() {
		return this.t2;
	}

	public void setJoinDateTest(Date joinDateTest) {
		this.joinDateTest = joinDateTest;
	}

	public Date getJoinDateTest() {
		return this.joinDateTest;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public BigDecimal getMoney() {
		return this.money;
	}

}