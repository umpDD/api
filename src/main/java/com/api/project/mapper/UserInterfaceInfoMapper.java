package com.api.project.mapper;

import com.api.project.model.vo.InterfaceInfoVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wuyi.apicommon.model.entity.UserInterfaceInfo;

import java.util.List;


public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    List<InterfaceInfoVO> listTopInvokeInterfaceInfo(int limit);

}




