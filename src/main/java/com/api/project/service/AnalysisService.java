package com.api.project.service;

import com.api.project.model.vo.InterfaceInfoVO;


import java.util.List;

public interface AnalysisService {

    List<InterfaceInfoVO> listTopInvokeInterfaceInfo(int limit);
}
