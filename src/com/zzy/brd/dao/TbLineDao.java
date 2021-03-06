package com.zzy.brd.dao;

import com.zzy.brd.entity.TbLine;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
//数据库的声明利用herbinate
/**
 * Created by wpr on 2021
 */
public interface TbLineDao extends BaseDao<TbLine>{
    @Query("select u from TbLine u where u.startAddress =?1 and u.endAddress =?2")
    List<TbLine> findByStartAddressAndEndAddress(String startAddress,String endAddress);

    @Query("select count(u) from TbLine u")
    int countLine();
}
