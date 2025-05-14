package com.ruoyi.system.domain.dto;

import lombok.Data;

@Data
public class RecommendRequestDTO {
    private Integer terrainType; // 地形类型（1-4）
    private Double altitude;     // 海拔
    private Double avgTemp;      // 平均气温
    private Double rainfall;     // 降水量
    private String climateZone;     // 气候带
}
