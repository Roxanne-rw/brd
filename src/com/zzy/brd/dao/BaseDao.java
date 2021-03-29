/*******************************************************************************
 * Copyright (c) 2005, 2014 zzy.cn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.zzy.brd.dao;
//数据库的声明利用herbinate
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * dao 基础接口

 */
@NoRepositoryBean
public abstract interface BaseDao<T> extends PagingAndSortingRepository<T, Long>, JpaSpecificationExecutor<T>  {
	
}
