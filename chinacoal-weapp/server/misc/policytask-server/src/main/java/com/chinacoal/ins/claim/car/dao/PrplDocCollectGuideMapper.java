package com.chinacoal.ins.claim.car.dao;

import com.chinacoal.ins.claim.car.pojo.PrplDocCollectGuide;

import java.util.List;

public interface PrplDocCollectGuideMapper {

	List<PrplDocCollectGuide> findDocCollects(String registNo);
}