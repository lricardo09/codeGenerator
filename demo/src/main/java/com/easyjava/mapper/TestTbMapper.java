package com.easyjava.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @description: 测试用表
 * @author: ricardo.m.lu
 * @date: 23-10-24
 */
public interface TestTbMapper<T, P> extends BaseMapper{
	/**
 	 * 根据userId查询
 	 */
	T selectByUser_id(@Param("userId") Integer userId);

	/**
 	 * 根据userId更新
 	 */
	Integer updateByUser_id(@Param("bean") T t, @Param("userId") Integer userId);

	/**
 	 * 根据userId删除
 	 */
	Integer deleteByUser_id(@Param("userId") Integer userId);


}