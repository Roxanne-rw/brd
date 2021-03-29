package com.zzy.brd.constant;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 静态变量类
 * 
 *
 * 
 */
public class Constant {


	/**
	 * 强制退出
	 */
	public final static String SESSION_FORCE_LOGOUT_KEY = "SESSION_FORCE_LOGOUT_KEY";
	public final static String SESSION_CURUSER_UUID = "SESSION_CURUSER_UUID";
	public final static String SESSION_CURUSER_USERTYPE = "SESSION_CURUSER_USERTYPE";
	public final static String EXITURL = "/cuser/logout";

	/**
	 * 登录密码加密
	 */
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;




	/**
	 * 用户登录相关
	 * */
	public final static int LOGIN_SUCC = 0;
	public final static int LOGIN_TYPE_USERNAME_ERROR = 1001;// 登录用户名错误
	public final static int LOGIN_TYPE_PASSWORD_ERROR = 1002;// 登录密码错误
	public final static int LOGIN_ERROR = 1003;// 其他错误

	/**
	 * 用户注册相关
	 * */
	public final static int REGISTER_SUCC = 0;
	public final static int REGISTER_TYPE_MOBILE_EXIST = 1001;// 注册手机号已存在
	public final static int REGISTER_SMS_AUTHCODE_ERROR = 1002;// 手机校验码错误
	public final static int REGISTER_SMS_AUTHCODE_TIMEOUT = 1003;// 手机校验码已失效
	public final static int REGISTER_ERROR = 1004;// 其他错误
	public final static int REGISTER_TYPE_USERNAME_EXIST = 1005;// 用户名已存在
	public final static int REGISTER_RECOMMENDED_ERROR = 1006;// 邀请人不能为自己
	public final static int REGISTER_CATCHA_ERROR = 1007;//验证码错误
	public final static int REGISTER_IDCARD_EXIST = 1008;// 身份证号码已被绑定
	public final static int REGISTER_USERNO_EXIST = 1009;//用户编号存在
	public final static int REGISTER_ASKPERSON_NOT_ON=1010;//推荐人未启用
	


	/**
	 * 修改密码相关
	 */
	public final static int MOD_PWD_SUCC = 0;
	public final static int MOD_PWD_TYPE_SAME = 1001;// 新密码和旧密码一样
	public final static int MOD_PWD_TYPE_AUTHCODE_ERROR = 1002;// 手机验证码错误
	public final static int MOD_PWD_ERROR = 1003;
	public final static int MOD_PWD_NOFOUND = 1004; // 用户不存在
	public final static int MOD_PWD_TYPE_AUTHCODE_TIMEOUT = 1005;// 手机校验码已失效
	public final static int MOD_PWD_ERROR_OLDPWD = 1006; // 旧密码错误

	


	/**
	 * Session中存放登录loginUser的key
	 */
	public final static String LOGIN_USER = "LOGIN_USER";
	/** 用户登录验证码*/
	public final static String KAPTCHA_SESSION_KEY_USER_LOGIN = "KAPTCHA_SESSION_KEY_USER_LOGIN";
	/** 用户注册验证码*/
	public final static String KAPTCHA_SESSION_KEY_USER_REGISTER = "KAPTCHA_SESSION_KEY_USER_REGISTER";
	
	/**
	 * 存放客户管理平台校验cookies值的key
	 */
	public final static String ADMIN_LOGIN_USER_COOKIES_KEY = "admin_cookies_vlaues";

	/**
	 * 存放功能管理平台（子站）校验cookies值的key
	 */
	public final static String LOGIN_USER_VALIDATE = "cookies_user_values";

	/**
	 * Session中存放登录验证码的key
	 */
	public final static String LOGIN_SAFECODE = "LOGIN_SAFECODE";

	/**
	 * 登录错误次数
	 */
	public final static String ERROR_LOGIN_TIMES = "ERROR_LOGIN_TIMES";

	/**
	 * Session中存放登录sysLoginUser的key
	 */
	public final static String SYS_LOGIN_USER = "SYS_LOGIN_USER";

	/**
	 * 存放校验cookies值的key
	 */
	public final static String SYS_LOGIN_USER_COOKIES_KEY = "sys_cookies_vlaues";

	/**
	 * 掺杂变量
	 */
	public final static String VALIDATE_SALT = ")!*-1=1lxl2323";

	/**
	 * 登录错误次数
	 */
	public final static String SYS_ERROR_LOGIN_TIMES = "SYS_ERROR_LOGIN_TIMES";
	public final static String SYS_ERROR_LOGIN_TIMES_AGENT = "SYS_ERROR_LOGIN_TIMES_AGENT";
	public final static String SYS_ERROR_LOGIN_TIMES_CUSTOMER = "SYS_ERROR_LOGIN_TIMES_CUSTOMER";
	public final static String SYS_ERROR_LOGIN_TIMES_ADMIN = "SYS_ERROR_LOGIN_TIMES_ADMIN";
	public final static int SYS_ERROR_LOGIN_TIMES_VALUE = 3;
	public final static String SYS_ERROR_LOGIN_USER_DISABLED = "SYS_ERROR_LOGIN_USER_DISABLED";
	public final static String SYS_ERROR_LOGIN_PERMISSION = "SYS_ERROR_LOGIN_PERMISSION";/** 登录权限*/

	/**
	 * Session中存放登录验证码的key
	 */
	public final static String SYS_LOGIN_SAFECODE = "SYS_LOGIN_SAFECODE";

	/**
	 * 登录错误次数
	 */
	public final static String REGIST_CODE = "REGIST_CODE";

	/**
	 * 登录错误次数
	 */
	public final static String REGIST_EXPIRE_TIME = "REGIST_EXPIRE_TIME";

	/**
	 * 分页大小
	 */
	public final static int PAGE_SIZE = 10;

	/**
	 * ajax查询分页大小
	 */
	public final static int AJAX_PAGE_SIZE = 50;

	/**
	 * 我的移站通产品列表分页大小
	 */
	public final static int SITE_MANAGE_PAGE_SIZE = 5;

	/**
	 * 用户ajaxSearch 分界值
	 */
	public final static int AJAX_SEARCH_WATERSHED = 300;

	/**
	 * API CHECKSUM_KEY
	 */
	public final static String CHECKSUM_KEY = "zzy_api_$*#@($&_!+__)(#@(*&@!@@zzy.cn";

	/**
	 * 系统端模拟登录的 KEY
	 */
	public final static String MONI_CHECKSUM_KEY = "@#$%^&*()###zzy";

	/**
	 * 模拟登录校验时间差
	 */
	public final static int MONI_TIMEOUT = 10;

	/**
	 * 图片上传临时路径
	 */
	public static final String TEMP_UPLOAD_DIR = "/temp";


}
