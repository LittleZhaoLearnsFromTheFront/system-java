package com.ruoyi.web.controller.common;

import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.system.domain.SysOrigin;
import com.ruoyi.system.domain.SysVariety;
import com.ruoyi.system.domain.dto.RecommendDTO;
import com.ruoyi.system.domain.dto.RecommendRequestDTO;
import com.ruoyi.system.domain.dto.RecommendResultDTO;
import com.ruoyi.system.service.ISysOriginService;
import com.ruoyi.system.service.ISysVarietyService;
import com.ruoyi.system.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/recommend")
public class RecommendController {

    @Autowired
    private RecommendService recommendService;
    @Autowired
    private ISysOriginService sysOriginService;
    @Autowired
    private ISysVarietyService  sysVarietyService;


    @PostMapping
    public ResponseEntity<ArrayList<RecommendDTO>> recommend(@RequestBody RecommendRequestDTO request) {
        ArrayList<RecommendDTO> recommendDTOS = new ArrayList<>();

        List<SysOrigin> varieties = sysOriginService.selectSysOriginList(new SysOrigin()); // 应替换为DB数据
        List<RecommendResultDTO> results = recommendService.recommend(request, varieties);
        for (RecommendResultDTO result : results) {

            SysVariety sysVariety = new SysVariety();
            sysVariety.setOriginId(result.getId());
            List<SysVariety> sysVarieties = sysVarietyService.selectSysVarietyList(sysVariety);
            if (sysVarieties.size() > 0) {
                for (SysVariety sysVariety1 : sysVarieties) {
                    RecommendDTO recommendDTO = new RecommendDTO();
                    BeanUtils.copyProperties(sysVariety1, recommendDTO);
                    recommendDTO.setScore(result.getScore());
                    recommendDTO.setReason(result.getReason());
                    recommendDTO.setName(result.getName());
                    recommendDTOS.add(recommendDTO);
                }
            }
        }
//        Collections.reverse(recommendDTOS);
        return ResponseEntity.ok(recommendDTOS);
    }
}
