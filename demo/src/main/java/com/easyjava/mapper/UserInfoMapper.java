package com.easyjava.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @description: 用户信息
 * @author: ricardo.m.lu
 * @date: 23-10-24
 */
public interface UserInfoMapper<T, P> extends BaseMapper{
	/**
 	 * 根据userId查询
 	 */
	T selectByUser_id(@Param("userId") String userId);

	/**
 	 * 根据userId更新
 	 */
	Integer updateByUser_id(@Param("bean") T t, @Param("userId") String userId);

	/**
 	 * 根据userId删除
 	 */
	Integer deleteByUser_id(@Param("userId") String userId);

	/**
 	 * 根据email查询
 	 */
	T selectByEmail(@Param("email") String email);

	/**
 	 * 根据email更新
 	 */
	Integer updateByEmail(@Param("bean") T t, @Param("email") String email);

	/**
 	 * 根据email删除
 	 */
	Integer deleteByEmail(@Param("email") String email);

	/**
 	 * 根据qqOpenId查询
 	 */
	T selectByQq_open_id(@Param("qqOpenId") String qqOpenId);

	/**
 	 * 根据qqOpenId更新
 	 */
	Integer updateByQq_open_id(@Param("bean") T t, @Param("qqOpenId") String qqOpenId);

	/**
 	 * 根据qqOpenId删除
 	 */
	Integer deleteByQq_open_id(@Param("qqOpenId") String qqOpenId);

	/**
 	 * 根据nickName查询
 	 */
	T selectByNick_name(@Param("nickName") String nickName);

	/**
 	 * 根据nickName更新
 	 */
	Integer updateByNick_name(@Param("bean") T t, @Param("nickName") String nickName);

	/**
 	 * 根据nickName删除
 	 */
	Integer deleteByNick_name(@Param("nickName") String nickName);

	/**
 	 * 根据t2和t1查询
 	 */
	T selectByT2AndT1(@Param("t2") Integer t2, @Param("t1") Integer t1);

	/**
 	 * 根据t2和t1更新
 	 */
	Integer updateByT2AndT1(@Param("bean") T t, @Param("t2") Integer t2, @Param("t1") Integer t1);

	/**
 	 * 根据t2和t1删除
 	 */
	Integer deleteByT2AndT1(@Param("t2") Integer t2, @Param("t1") Integer t1);


}