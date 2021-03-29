/*******************************************************************************
 * Copyright (c) 2005, 2014 zzy.cn
 *
 * 
 *******************************************************************************/
package com.zzy.brd.enums;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;

/**
 * 权限 部分用
 */
public enum Permission {
	
	/**
	 * 登录权限
	 */
	/**　前台登录*/
	LOGIN_MANAGER_FRONT,
	/** 后台登录*/
	LOGIN_MANAGER_BACK,
	

	USER_MANAGER,

	USER_UPGRADE,
	

	ORGANIZATION_MANAGER_DEPART,

	ORGANIZATION_MANAGER_USER,

	ORGANIZATION_MANAGER_ROLE,
	

	ORDER_MANAGER,

	ORDER_MANAGER_PC,

	ORDER_MANAGER_BROKERAGE,

	ORDER_MANAGER_WITHDRAW,

	/*PRODUCT_MANAGER,*/

	PRODUCT_MANAGER,

	PRODUCT_MANAGER_TYPE,
	

	ACTIVITY_MANAGER_STAR,

	ACTIVITY_MANAGER_APPRENTICE,

	ACTIVITY_MANAGER_REGISTER,

	ACTIVITY_MANAGER_QRCODE,
	

	TEXT_MANAGER_ACTIVITY,

	TEXT_MANAGER_HELP,

	TEXT_MANAGER_APPRENTICE,

	TEXT_MANAGER_ABOUTUS,

	TEXT_MANGER_PC_ACTIVITY,
	

	AD_MANAGER_PC,

	AD_MANAGER_WEIXIN,
	
	/**
	 * 平台设置
	 */
	/** 基础设置*/
	SET_MANAGER_BASE,
	/** 消息模块*/
	SET_MANAGER_INFO,
	/** 服务协议*/
	SET_MANAGER_AGGREMENT,
	/** 微信推送*/
	SET_WECHAT_NOTIFY,
	/** 订单通知*/
	SET_ORDERFORM_NOTIFY,
	/**SEO设置*/
	SET_SEO_SETTING,
	/**友情链接*/
	SET_FRIENDSHIPLINK,

	STATISTICS_MANAGER_USER,

	STATISTICS_REPORT_USER,

	STATISTICS_MANAGER_ORDER,

	STATISTICS_MANAGER_PRODUCT,

	STATISTICS_MANAGER_DEPART,

	STATISTICS_MANAGER_BROKERAGE,

	STATISTICS_SELLER,
	/**
	 * 系统日志
	 */
	SYS_LOG,
	/**
	 * 导出
	 */
	USER_EXPORT,
	
	;
	
	
	
	public static Set<String> allPermissions = Sets.newHashSet();
	public static String allPermissionStr = "";
	static {
		for (Permission permission : Permission.values()) {
			allPermissions.add(permission.name());
		}
		allPermissionStr = StringUtils.join(allPermissions, ";");
	}
	
	/**
	 * 判断是否可以拥有该权限
	 * @return boolean
	 */
	//权限集
	static Set<Permission> availableForCustomerSet = Sets.
		newHashSet();
	public boolean isCanContainForCustomer() {
		if (availableForCustomerSet.contains(this)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 转换enum
	 * @param permissions
	 * @return
	 */
	public static Set<Permission> permissions(String[] permissions) {
		Set<Permission> set = Sets.newHashSet();
		for (String permission : permissions) {
			Permission permissionT = Permission.valueOf(permission);
			if (permissionT != null) {
				set.add(permissionT);
			}
		}
		return set;
	}
	
	/**
	 * 解析权限集字符串
	 * @param permissionStr
	 * @return
	 */
	public static Set<Permission> permissions(String permissionStr) {
		Set<Permission> set = Sets.newHashSet();
		for (String permission : StringUtils.split(permissionStr,";")) {
			Permission per = value(permission);
			if (per != null) {
				set.add(per);
			}
		}
		return set;
	}
	
	/**
	 * 获取权限集字符串
	 * @param permissions
	 * @return
	 */
	public static String permissionsStr(Set<Permission> permissions) {
		if (permissions == null || permissions.size() == 0) {
			return "";
		}
		return StringUtils.join(permissions, ";");
	}
	
	/**
	 * 过滤权限集
	 * @param permissions
	 * @return
	 */
	public static String permissionsStr(String permissions) {
		return permissionsStr(permissions(permissions));
	}
	
	/**
	 * 过滤非法权限集
	 * @param permissions
	 * @return
	 */
	public static String permissionsStrForCustomer(String permissions) {
		//过滤非法权限
		Set<Permission> set = Sets.filter(permissions(permissions), new Predicate<Permission>() {
			@Override
			public boolean apply(Permission permission) {
				return permission.isCanContainForCustomer();
			}
		});
		return permissionsStr(set);
	}
	
	public static Permission value(String value) {
		if (allPermissions.contains(value)) {
			return Permission.valueOf(value);
		}
		return null;
	}
	
}
