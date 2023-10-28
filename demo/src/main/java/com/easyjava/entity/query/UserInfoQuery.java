package com.easyjava.entity.query;


import java.util.Date;
/**
 * @description: 用户信息
 * @author: ricardo.m.lu
 * @date: 23-10-28
 */
public class UserInfoQuery extends BaseQuery {
	/**
 	 * 用户id
 	 */
	private String userId;
	private String userIdFuzzy;
	/**
 	 * 昵称
 	 */
	private String nickName;
	private String nickNameFuzzy;
	/**
 	 * 邮箱
 	 */
	private String email;
	private String emailFuzzy;
	/**
 	 * qq open id
 	 */
	private String qqOpenId;
	private String qqOpenIdFuzzy;
	/**
 	 * qq头像
 	 */
	private String qqAvatar;
	private String qqAvatarFuzzy;
	/**
 	 * 密码
 	 */
	private String password;
	private String passwordFuzzy;
	/**
 	 * 注册时间
 	 */
	private Date joinTime;
	private String joinTimeStart;
	private String joinTimeEnd;
	/**
 	 * 上次登录时间
 	 */
	private Date lastLoginTime;
	private String lastLoginTimeStart;
	private String lastLoginTimeEnd;
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

	public void setJoinTimeStart(String joinTimeStart) {
		this.joinTimeStart = joinTimeStart;
	}

	public String getJoinTimeStart() {
		return this.joinTimeStart;
	}
	public void setJoinTimeEnd(String joinTimeEnd) {
		this.joinTimeEnd = joinTimeEnd;
	}

	public String getJoinTimeEnd() {
		return this.joinTimeEnd;
	}

	public void setLastLoginTimeStart(String lastLoginTimeStart) {
		this.lastLoginTimeStart = lastLoginTimeStart;
	}

	public String getLastLoginTimeStart() {
		return this.lastLoginTimeStart;
	}
	public void setLastLoginTimeEnd(String lastLoginTimeEnd) {
		this.lastLoginTimeEnd = lastLoginTimeEnd;
	}

	public String getLastLoginTimeEnd() {
		return this.lastLoginTimeEnd;
	}

	public void setUserIdFuzzy(String userIdFuzzy) {
		this.userIdFuzzy = userIdFuzzy;
	}

	public String getUserIdFuzzy() {
		return this.userIdFuzzy;
	}
	public void setNickNameFuzzy(String nickNameFuzzy) {
		this.nickNameFuzzy = nickNameFuzzy;
	}

	public String getNickNameFuzzy() {
		return this.nickNameFuzzy;
	}
	public void setEmailFuzzy(String emailFuzzy) {
		this.emailFuzzy = emailFuzzy;
	}

	public String getEmailFuzzy() {
		return this.emailFuzzy;
	}
	public void setQqOpenIdFuzzy(String qqOpenIdFuzzy) {
		this.qqOpenIdFuzzy = qqOpenIdFuzzy;
	}

	public String getQqOpenIdFuzzy() {
		return this.qqOpenIdFuzzy;
	}
	public void setQqAvatarFuzzy(String qqAvatarFuzzy) {
		this.qqAvatarFuzzy = qqAvatarFuzzy;
	}

	public String getQqAvatarFuzzy() {
		return this.qqAvatarFuzzy;
	}
	public void setPasswordFuzzy(String passwordFuzzy) {
		this.passwordFuzzy = passwordFuzzy;
	}

	public String getPasswordFuzzy() {
		return this.passwordFuzzy;
	}
}