package com.chinacoal.ins.claim.car.dao;

import com.chinacoal.ins.claim.car.pojo.PrpLpayment;

import java.util.HashMap;
import java.util.List;

public interface PrpLpaymentMapper {

     /**
     * 查询支付信息
     * @author: wen
     * @date: 2018/11/20 11:40
     * @param: [queryMap]
     * @return: java.util.List<com.chinacoal.ins.claim.car.pojo.PrpLpayment>
     */
    List<PrpLpayment> findPayMent(HashMap<String,String> queryMap);
}