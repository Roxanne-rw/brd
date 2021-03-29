/*******************************************************************************
 * Copyright (c) 2005, 2014 zzy.cn
 *
 * 
 *******************************************************************************/
package com.zzy.brd.service;


import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springside.modules.mapper.BeanMapper;
import org.springside.modules.utils.Reflections;
import com.google.common.collect.Lists;
import com.zzy.brd.util.persistence.DynamicSpecifications;
import com.zzy.brd.util.persistence.SearchFilter;




/**
 //对应功能的业务逻辑
 //分页
 */
public class BaseService {
	private static final Logger logger = LoggerFactory.getLogger(BaseService.class);

	
	static {
		DozerBeanMapper mapper = (DozerBeanMapper) Reflections.getFieldValue(
				new BeanMapper(), "dozer");
		mapper.setMappingFiles(Lists.newArrayList("globalConfig.xml"));
	}
	

	
	/**
	 * 创建分页请求.
	 * 
	 * @param pageNumber
	 *            页号
	 * @param pageSize
	 *            每页大小
	 * @param sortType
	 *            排序字段 默认：id 支持按多字段排序 "id:asc,name:desc" "id,name:desc"
	 * @param asc
	 *            是否升序
	 * @return PageRequest
	 */
	protected PageRequest createPageRequest(int pageNumber, int pageSize,
			String sortType, boolean asc) {
		Sort sort = createSort(sortType, asc);
		return new PageRequest(pageNumber - 1, pageSize, sort);
	}

	/**
	 * 
	 * @param sortType
	 *            排序字段 默认：id 支持按多字段排序 "id:asc,name:desc" "id,name:desc"
	 * @param asc
	 *            是否升序
	 * @return
	 */
	protected Sort createSort(String sortType, boolean asc) {
		Sort sort = null;
		Direction defaultDirection = asc ? Direction.ASC : Direction.DESC;

		// 设置默认值
		if (StringUtils.isBlank(sortType)) {
			sortType = "id";
		}

		List<Sort.Order> orders = Lists.newArrayList();
		Direction otherDirection;
		for (String sortStr : sortType.split(",")) {
			String sortAndDirection[] = sortStr.split(":");
			if (sortAndDirection.length < 1) {
				continue;
			}
			if (sortAndDirection.length == 2) {
				otherDirection = sortAndDirection[1].equalsIgnoreCase("asc") ? Direction.ASC
						: Direction.DESC;
			} else {
				otherDirection = defaultDirection;
			}
			orders.add(new Sort.Order(otherDirection, sortAndDirection[0]));
		}
		sort = new Sort(orders);
		return sort;
	}
	/**
	 * 创建动态查询条件组合.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Specification<?> createSpecification(
			Map<String, Object> searchParams, Class entityClass) {
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		Specification spec = DynamicSpecifications.bySearchFilter(
				filters.values(), entityClass);
		return spec;
	}
}
