package com.zzy.brd.dao;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.zzy.brd.entity.SysInfo;
//数据库的声明利用herbinate
/**
平台设置
 **/
public interface SysInfoDao extends BaseDao<SysInfo> {

	@Modifying
	@Query("update SysInfo s set s.websiteTotalPv = s.websiteTotalPv +1 ")
	public void updatePv();

}
