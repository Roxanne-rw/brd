/*******************************************************************************
 * Copyright (c) 2005, 2014 zzy.cn
 *
 * 
 *******************************************************************************/
package com.zzy.brd.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.authc.UserFilter;

/**
 * 去除记住旧url功能

 */
public class MyuserFilter extends UserFilter {
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //saveRequestAndRedirectToLogin(request, response);
        redirectToLogin(request, response);
        return false;
    }
}
