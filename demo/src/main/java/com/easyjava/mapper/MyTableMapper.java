package com.easyjava.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @description: 
 * @author: ricardo.m.lu
 * @date: 23-10-28
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

	/**
 	 * 根据iOrU查询
 	 */
	T selectByI_or_u(@Param("iOrU") String iOrU);

	/**
 	 * 根据iOrU更新
 	 */
	Integer updateByI_or_u(@Param("bean") T t, @Param("iOrU") String iOrU);

	/**
 	 * 根据iOrU删除
 	 */
	Integer deleteByI_or_u(@Param("iOrU") String iOrU);

	/**
 	 * 根据yy查询
 	 */
	T selectByYy(@Param("yy") String yy);

	/**
 	 * 根据yy更新
 	 */
	Integer updateByYy(@Param("bean") T t, @Param("yy") String yy);

	/**
 	 * 根据yy删除
 	 */
	Integer deleteByYy(@Param("yy") String yy);


}