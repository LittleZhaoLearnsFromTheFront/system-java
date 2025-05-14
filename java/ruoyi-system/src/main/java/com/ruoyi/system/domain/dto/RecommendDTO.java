package com.ruoyi.system.domain.dto;

import com.ruoyi.system.domain.SysVariety;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecommendDTO  extends SysVariety {
    private String name;
    private double score;
    private String reason;

    public RecommendDTO() {

    }
}
