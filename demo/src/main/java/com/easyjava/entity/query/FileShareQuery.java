package com.easyjava.entity.query;


import java.util.Date;
/**
 * @description: 分享信息
 * @author: ricardo.m.lu
 * @date: 23-10-24
 */
public class FileShareQuery extends BaseQuery {
	/**
 	 * 
 	 */
	private String shareId;
	private String shareIdFuzzy;
	/**
 	 * 
 	 */
	private String fileId;
	private String fileIdFuzzy;
	/**
 	 * 
 	 */
	private String userId;
	private String userIdFuzzy;
	/**
 	 * 有效期类型 0:1天 1:7天 2:30天 3:永久有效
 	 */
	private Integer validType;

	/**
 	 * 分享时间
 	 */
	private Date shareTime;
	private String shareTimeStart;
	private String shareTimeEnd;
	/**
 	 * 失效时间
 	 */
	private Date expireTime;
	private String expireTimeStart;
	private String expireTimeEnd;
	/**
 	 * 提取码
 	 */
	private String code;
	private String codeFuzzy;
	/**
 	 * 浏览次数
 	 */
	private Integer showCount;

	public void setShareId(String shareId) {
		this.shareId = shareId;
	}

	public String getShareId() {
		return this.shareId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileId() {
		return this.fileId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setValidType(Integer validType) {
		this.validType = validType;
	}

	public Integer getValidType() {
		return this.validType;
	}

	public void setShareTime(Date shareTime) {
		this.shareTime = shareTime;
	}

	public Date getShareTime() {
		return this.shareTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public Date getExpireTime() {
		return this.expireTime;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public void setShowCount(Integer showCount) {
		this.showCount = showCount;
	}

	public Integer getShowCount() {
		return this.showCount;
	}

	public void setShareTimeStart(String shareTimeStart) {
		this.shareTimeStart = shareTimeStart;
	}

	public String getShareTimeStart() {
		return this.shareTimeStart;
	}
	public void setShareTimeEnd(String shareTimeEnd) {
		this.shareTimeEnd = shareTimeEnd;
	}

	public String getShareTimeEnd() {
		return this.shareTimeEnd;
	}

	public void setExpireTimeStart(String expireTimeStart) {
		this.expireTimeStart = expireTimeStart;
	}

	public String getExpireTimeStart() {
		return this.expireTimeStart;
	}
	public void setExpireTimeEnd(String expireTimeEnd) {
		this.expireTimeEnd = expireTimeEnd;
	}

	public String getExpireTimeEnd() {
		return this.expireTimeEnd;
	}

	public void setShareIdFuzzy(String shareIdFuzzy) {
		this.shareIdFuzzy = shareIdFuzzy;
	}

	public String getShareIdFuzzy() {
		return this.shareIdFuzzy;
	}
	public void setFileIdFuzzy(String fileIdFuzzy) {
		this.fileIdFuzzy = fileIdFuzzy;
	}

	public String getFileIdFuzzy() {
		return this.fileIdFuzzy;
	}
	public void setUserIdFuzzy(String userIdFuzzy) {
		this.userIdFuzzy = userIdFuzzy;
	}

	public String getUserIdFuzzy() {
		return this.userIdFuzzy;
	}
	public void setCodeFuzzy(String codeFuzzy) {
		this.codeFuzzy = codeFuzzy;
	}

	public String getCodeFuzzy() {
		return this.codeFuzzy;
	}
}