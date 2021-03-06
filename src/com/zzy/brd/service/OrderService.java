package com.zzy.brd.service;

import com.zzy.brd.dao.TbOrderDao;
import com.zzy.brd.entity.TbOrder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
//对应功能的业务逻辑
/**
 * Created by wpr on 2021
 */
@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class OrderService extends BaseService{

    @Autowired
    private TbOrderDao tbOrderDao;

    /**
     *
     * @param searchParams
     * @param sortName
     * @param sortType
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<TbOrder> adminOrderformList(Map<String,Object> searchParams, String sortName, String sortType, int pageNum, int pageSize){
        PageRequest pageRequest ;
        if(!StringUtils.isBlank(sortName) && !StringUtils.isBlank(sortType)){
            String sort = sortName+":"+sortType;
            pageRequest = createPageRequest(pageNum, pageSize, sort, false);
        }else{
            pageRequest = createPageRequest(pageNum,pageSize,"orderTime:desc",false);
        }
        @SuppressWarnings("unchecked")
        Specification<TbOrder> spec = (Specification<TbOrder>) createSpecification(
                searchParams, TbOrder.class);
        Page<TbOrder> result = tbOrderDao.findAll(spec, pageRequest);
        return result;
    }
    /*统计订单状态的值
     */
    public int countOrderStatus(TbOrder.OrderStatus orderStatus){
        int count =tbOrderDao.countOrderStatus(orderStatus);
        return count;
    }
}
