package com.easyjava.entity.po;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * @description: 测试用表
 * @author: ricardo.m.lu
 * @date: 23-10-24
 */
public class TestTb implements Serializable {
	/**
 	 * 
 	 */
	@JsonIgnore
	private Integer userId;

	/**
 	 * 
 	 */
	private Integer column2;

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setColumn2(Integer column2) {
		this.column2 = column2;
	}

	public Integer getColumn2() {
		return this.column2;
	}

}