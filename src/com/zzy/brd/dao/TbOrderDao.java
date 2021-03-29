package com.zzy.brd.dao;

import com.zzy.brd.entity.TbOrder;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
//数据库的声明利用herbinate
/**
 * Created by wpr on 2021
 */
public interface TbOrderDao extends BaseDao<TbOrder>{

    @Query("select u from TbOrder u where u.lineId =?1")
    List<TbOrder> findTbOrderByLineId(Long lineId);

    @Query("select count(u) from TbOrder u where u.orderStatus =?1")
    int countOrderStatus(TbOrder.OrderStatus orderStatus);
}
