package com.chinacoal.ins.claim.car.dao;

import com.chinacoal.ins.claim.car.pojo.ClaimMoneyDto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * @author: wen
 * @date: 2018/11/20 10:47
 * @description: ������ؽ��Mapper
 */
public interface ClaimMoneyMapper {

	 /**
	 * ��������: ��ѯ��ǰ�����µ���ؽ��
	 * @author: wen
	 * @date: 2018/11/20 10:48
	 * @param: [claimNo]
	 * @return: java.util.List<com.chinacoal.ins.claim.car.pojo.ClaimMoneyDto>
	 */
	List<ClaimMoneyDto> findByClaimNo(String claimNo);
	/**
	 * ��������: ��ѯ���⻷�ڵ������
	 * @author: wen
	 * @date: 2018/11/19 15:27
	 * @param: [queryMap]
	 * @return: java.math.BigDecimal
	 */
	BigDecimal querySumPaidForUndwrt(HashMap<String,String> queryMap);
	/**
	 * ��������: ��ѯ������
	 * @author: wen
	 * @date: 2018/11/19 16:08
	 * @param: [id]
	 * @return: java.math.BigDecimal
	 */
	BigDecimal querySumPaidForLoss(BigDecimal id);
	/**
	 * ��������: ��ѯ�᰸���������
	 * @author: wen
	 * @date: 2018/11/20 10:02
	 * @param: [queryMap]
	 * @return: java.math.BigDecimal
	 */
	BigDecimal querySumpaidForEndCase(HashMap<String,String> queryMap);
}
