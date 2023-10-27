package com.easyjava.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @description: 
 * @author: ricardo.m.lu
 * @date: 23-10-27
 */
public interface MyTableMapper<T, P> extends BaseMapper{
	/**
 	 * 根据myId查询
 	 */
	T selectByMy_id(@Param("myId") Integer myId);

	/**
 	 * 根据myId更新
 	 */
	Integer updateByMy_id(@Param("bean") T t, @Param("myId") Integer myId);

	/**
 	 * 根据myId删除
 	 */
	Integer deleteByMy_id(@Param("myId") Integer myId);


}