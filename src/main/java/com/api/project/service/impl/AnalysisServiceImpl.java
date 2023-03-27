package com.api.project.service.impl;

import com.api.project.common.ErrorCode;
import com.api.project.exception.BusinessException;
import com.api.project.mapper.UserInterfaceInfoMapper;
import com.api.project.model.vo.InterfaceInfoVO;
import com.api.project.service.AnalysisService;
import com.api.project.service.InterfaceInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wuyi.apicommon.model.entity.InterfaceInfo;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class AnalysisServiceImpl implements AnalysisService {

	@Resource
	private UserInterfaceInfoMapper userInterfaceInfoMapper;

	@Resource
	private InterfaceInfoService interfaceInfoService;

	@Override
	public List<InterfaceInfoVO> listTopInvokeInterfaceInfo(int limit) {
		List<InterfaceInfoVO> vos = userInterfaceInfoMapper.listTopInvokeInterfaceInfo(limit);
		if (vos == null || vos.size() == 0) {
			throw new BusinessException(ErrorCode.SYSTEM_ERROR);
		}
		// 根据id查询接口名称
		LinkedHashMap<Long, InterfaceInfoVO> voHashMap = new LinkedHashMap<>(vos.size());
		for (InterfaceInfoVO vo : vos) {
			voHashMap.put(vo.getId(), vo);
		}
		LambdaQueryWrapper<InterfaceInfo> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.in(InterfaceInfo::getId, voHashMap.keySet());
		List<InterfaceInfo> infoList = interfaceInfoService.list(queryWrapper);

		for (InterfaceInfo interfaceInfo : infoList) {
			voHashMap.get(interfaceInfo.getId()).setName(interfaceInfo.getName());
		}

		return new ArrayList<>(voHashMap.values());
	}
	
}