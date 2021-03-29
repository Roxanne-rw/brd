/*******************************************************************************
 * Copyright (c) 2005, 2014 zzy.cn
 *
 * 
 *******************************************************************************/
package com.zzy.brd.dao;

import com.zzy.brd.entity.SmsAuthcode;
//数据库的声明利用herbinate

/**
 * 短信校验码DAO
 */
public interface SmsAuthcodeDao extends BaseDao<SmsAuthcode> {
	//根据手机号码查询记录
	SmsAuthcode findByTelenoAndSource(String teleno, short source);
}
