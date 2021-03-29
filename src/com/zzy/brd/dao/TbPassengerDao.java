package com.zzy.brd.dao;

import com.zzy.brd.entity.TbPassenger;
import org.springframework.data.jpa.repository.Query;
//数据库的声明利用herbinate
/**
 * Created by wpr on 2021
 */
public interface TbPassengerDao extends BaseDao<TbPassenger>{

    @Query("select count(u) from TbPassenger u where u.state =?1")
    int countTbPassengerByState(TbPassenger.State state);
}
