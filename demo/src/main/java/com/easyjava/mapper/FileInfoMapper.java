package com.easyjava.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @description: 文件信息表
 * @author: ricardo.m.lu
 * @date: 23-10-24
 */
public interface FileInfoMapper<T, P> extends BaseMapper{
	/**
 	 * 根据fileId和userId查询
 	 */
	T selectByFile_idAndUser_id(@Param("fileId") String fileId, @Param("userId") String userId);

	/**
 	 * 根据fileId和userId更新
 	 */
	Integer updateByFile_idAndUser_id(@Param("bean") T t, @Param("fileId") String fileId, @Param("userId") String userId);

	/**
 	 * 根据fileId和userId删除
 	 */
	Integer deleteByFile_idAndUser_id(@Param("fileId") String fileId, @Param("userId") String userId);


}