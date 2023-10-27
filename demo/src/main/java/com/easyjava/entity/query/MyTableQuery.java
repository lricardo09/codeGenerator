package com.easyjava.entity.query;


/**
 * @description: 
 * @author: ricardo.m.lu
 * @date: 23-10-27
 */
public class MyTableQuery extends BaseQuery {
	/**
 	 * 
 	 */
	private Integer myId;

	/**
 	 * 
 	 */
	private Integer name;

	public void setMyId(Integer myId) {
		this.myId = myId;
	}

	public Integer getMyId() {
		return this.myId;
	}

	public void setName(Integer name) {
		this.name = name;
	}

	public Integer getName() {
		return this.name;
	}

}