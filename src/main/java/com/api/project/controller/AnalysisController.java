package com.api.project.controller;


import com.api.project.annotation.AuthCheck;
import com.api.project.common.BaseResponse;
import com.api.project.common.ResultUtils;
import com.api.project.model.vo.InterfaceInfoVO;
import com.api.project.service.AnalysisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分析控制器
 */
@RestController
@RequestMapping("/analysis")
@Slf4j
public class AnalysisController {

    @Resource
    private AnalysisService analysisService;

    @GetMapping("/top/interface/invoke")
    @AuthCheck(mustRole = "admin")
    BaseResponse<List<InterfaceInfoVO>> listTopInvokeInterfaceInfo () {
        List<InterfaceInfoVO> listTopInvokeInterfaceInfo = analysisService.listTopInvokeInterfaceInfo(3);
        return ResultUtils.success(listTopInvokeInterfaceInfo);
    }
}
