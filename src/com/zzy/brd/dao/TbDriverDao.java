package com.zzy.brd.dao;
//数据库的声明利用herbinate
import com.zzy.brd.entity.TbDriver;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by wpr on 2021
 */
public interface TbDriverDao extends BaseDao<TbDriver>{

    @Query("select u from TbDriver u where u.mobileno =?1")
    List<TbDriver> findTbDriverByMobileno(String mobileno);

    @Query("select count(u) from TbDriver u where u.driverStatus =?1")
    int countDriverState( TbDriver.DriverStatus driverStatus);
}
