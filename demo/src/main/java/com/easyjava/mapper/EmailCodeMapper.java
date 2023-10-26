package com.easyjava.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @description: 
 * @author: ricardo.m.lu
 * @date: 23-10-24
 */
public interface EmailCodeMapper<T, P> extends BaseMapper{
	/**
 	 * 根据email和code查询
 	 */
	T selectByEmailAndCode(@Param("email") String email, @Param("code") String code);

	/**
 	 * 根据email和code更新
 	 */
	Integer updateByEmailAndCode(@Param("bean") T t, @Param("email") String email, @Param("code") String code);

	/**
 	 * 根据email和code删除
 	 */
	Integer deleteByEmailAndCode(@Param("email") String email, @Param("code") String code);


}