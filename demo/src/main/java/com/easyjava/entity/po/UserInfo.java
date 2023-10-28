package com.easyjava.entity.po;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * @description: 用户信息
 * @author: ricardo.m.lu
 * @date: 23-10-28
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
	private Long usedSpace;

	/**
 	 * 总空间
 	 */
	private Long totalSpace;

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

	public void setUsedSpace(Long usedSpace) {
		this.usedSpace = usedSpace;
	}

	public Long getUsedSpace() {
		return this.usedSpace;
	}

	public void setTotalSpace(Long totalSpace) {
		this.totalSpace = totalSpace;
	}

	public Long getTotalSpace() {
		return this.totalSpace;
	}

}//哈哈哈开心