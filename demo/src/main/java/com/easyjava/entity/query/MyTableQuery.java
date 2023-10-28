package com.easyjava.entity.query;


/**
 * @description: 
 * @author: ricardo.m.lu
 * @date: 23-10-28
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

	/**
 	 * 
 	 */
	private String iOrU;
	private String iOrUFuzzy;
	/**
 	 * 
 	 */
	private Integer aB;

	/**
 	 * 
 	 */
	private String yy;
	private String yyFuzzy;
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

	public void setIOrU(String iOrU) {
		this.iOrU = iOrU;
	}

	public String getIOrU() {
		return this.iOrU;
	}

	public void setAB(Integer aB) {
		this.aB = aB;
	}

	public Integer getAB() {
		return this.aB;
	}

	public void setYy(String yy) {
		this.yy = yy;
	}

	public String getYy() {
		return this.yy;
	}

	public void setIOrUFuzzy(String iOrUFuzzy) {
		this.iOrUFuzzy = iOrUFuzzy;
	}

	public String getIOrUFuzzy() {
		return this.iOrUFuzzy;
	}
	public void setYyFuzzy(String yyFuzzy) {
		this.yyFuzzy = yyFuzzy;
	}

	public String getYyFuzzy() {
		return this.yyFuzzy;
	}
}