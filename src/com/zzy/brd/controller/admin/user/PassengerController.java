package com.zzy.brd.controller.admin.user;
//访问页面 请求页面路径 请求方法
import com.zzy.brd.constant.Constant;
import com.zzy.brd.entity.TbOrder;
import com.zzy.brd.entity.TbPassenger;
import com.zzy.brd.service.PassengerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wpr on 2021
 */
@Controller
@RequestMapping("admin/passenger")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @RequestMapping("list")
    public String list(@RequestParam(value = "page",required = true,defaultValue = "1") int pageNum
            , @RequestParam(value = "status",required = false,defaultValue = "") String status
            , @RequestParam(value = "sortName",required = false,defaultValue = "") String sortName
            , @RequestParam(value = "sortType",required = false,defaultValue = "") String sortType
            , @RequestParam(value = "searchName",required = false,defaultValue ="") String searchName
            , @RequestParam(value = "searchValue",required = false,defaultValue = "") String searchValue
            , HttpServletRequest request, Model model){
        Map<String,Object> searchParams = new HashMap<String, Object>();
        if(!StringUtils.isBlank(status)){
            if("0".equals(status)){
                searchParams.put("EQ_state", 0);
            }
            if("1".equals(status)){
                searchParams.put("EQ_state", 1);
            }
            if("2".equals(status)){
                searchParams.put("EQ_state", 2);
            }
        }
        if(!StringUtils.isBlank(searchName)){
            if("userName".equals(searchName)){
                String search = "LIKE_userName";
                searchParams.put(search, searchValue);
            }
            if("mobileno".equals(searchName)){
                String search = "LIKE_mobileno";
                searchParams.put(search, searchValue);
            }

        }

        Page<TbPassenger> passengerforms = passengerService.adminPassengerformList(searchParams, sortName, sortType, pageNum, Constant.PAGE_SIZE);
        model.addAttribute("passengerforms", passengerforms);
        model.addAttribute("status", status);
        model.addAttribute("sortName", sortName);
        model.addAttribute("sortType", sortType);
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchValue", searchValue);
        model.addAttribute("page", pageNum);
        model.addAttribute("queryStr", request.getQueryString());
        model.addAttribute("totalcount", passengerforms.getTotalElements());
        return "admin/passenger/passengerlist";
    }
}
