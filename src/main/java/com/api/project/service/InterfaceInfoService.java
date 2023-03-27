package com.api.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wuyi.apicommon.model.entity.InterfaceInfo;


public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
