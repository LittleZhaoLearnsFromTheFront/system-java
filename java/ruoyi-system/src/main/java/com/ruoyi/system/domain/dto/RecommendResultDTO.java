package com.ruoyi.system.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecommendResultDTO {
    private Long id;
    private String name;
    private double score;
    private String reason;
}
