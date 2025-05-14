package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysOrigin;
import com.ruoyi.system.domain.dto.RecommendRequestDTO;
import com.ruoyi.system.domain.dto.RecommendResultDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendService {

    public List<RecommendResultDTO> recommend(RecommendRequestDTO request, List<SysOrigin> allVarieties) {
        List<RecommendResultDTO> results = new ArrayList<>();

        for (SysOrigin origin : allVarieties) {
            double score = 0;
            StringBuilder reason = new StringBuilder();

            // 地形匹配
            if (Long.toString(origin.getTerrainType()).contains(Integer.toString(request.getTerrainType()))) {
                score += 20;
                reason.append("地形匹配; ");
            }

            // 气候带匹配
            if (origin.getClimateZone().contains(request.getClimateZone())) {
                score += 20;
                reason.append("气候带匹配; ");
            }

            // 温度评分（越接近越高）
            double tempScore = calculateRangeScore(request.getAvgTemp(), origin.getMinTemperature().doubleValue(), origin.getMaxTemperature().doubleValue());
            score += tempScore * 20;
            if (tempScore > 0.5) reason.append("气温适宜; ");

            // 海拔评分
            double altScore = calculateRangeScore(request.getAltitude(), origin.getMinAltitude().doubleValue(), origin.getMaxAltitude().doubleValue());
            score += altScore * 20;
            if (altScore > 0.5) reason.append("海拔适宜; ");

            // 降水评分
            double rainScore = calculateRangeScore(request.getRainfall(), origin.getMinPrecipitation().doubleValue(), origin.getMaxPrecipitation().doubleValue());
            score += rainScore * 20;
            if (rainScore > 0.5) reason.append("降水适宜; ");

            results.add(new RecommendResultDTO(origin.getOriginId(),origin.getOriginName(), score, reason.toString()));
        }

        // 排序，分数高的排前面
        return results.stream()
                .sorted(Comparator.comparingDouble(RecommendResultDTO::getScore).reversed())
                .limit(5) // 取前5个
                .collect(Collectors.toList());
    }

    private double calculateRangeScore(Double value, Double min, Double max) {
        if (value == null || min == null || max == null) return 0;
        if (value < min || value > max) return 0;

        // 在区间中靠近中心得分越高
        double center = (min + max) / 2.0;
        double halfRange = (max - min) / 2.0;
        return 1.0 - Math.abs(value - center) / halfRange;
    }
}
