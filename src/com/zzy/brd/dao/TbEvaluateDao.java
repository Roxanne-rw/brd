package com.zzy.brd.dao;

import com.zzy.brd.entity.TbEvaluate;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
//数据库的声明利用herbinate
/**
 * Created by wpr on 2021
 */
public interface TbEvaluateDao extends BaseDao<TbEvaluate> {
    @Query("select u from TbEvaluate u where u.driverId =?1")
    List<TbEvaluate> findTbEvaluateByDriverId(Long driverId);
}
