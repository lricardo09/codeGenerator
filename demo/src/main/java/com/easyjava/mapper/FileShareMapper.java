package com.easyjava.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @description: 分享信息
 * @author: ricardo.m.lu
 * @date: 23-10-24
 */
public interface FileShareMapper<T, P> extends BaseMapper{
	/**
 	 * 根据shareId查询
 	 */
	T selectByShare_id(@Param("shareId") String shareId);

	/**
 	 * 根据shareId更新
 	 */
	Integer updateByShare_id(@Param("bean") T t, @Param("shareId") String shareId);

	/**
 	 * 根据shareId删除
 	 */
	Integer deleteByShare_id(@Param("shareId") String shareId);


}