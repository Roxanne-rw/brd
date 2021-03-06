package com.zzy.brd.algorithm.encrypt.shiro;
//修改密码的信息实体
public class PasswordInfo {
	private String password;
	private String salt;
	
	/***
	 * 获得加密后的密码
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/***
	 * 获得salt
	 * @return
	 */
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
