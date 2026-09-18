package com.neurotrack.backend.service;

import com.neurotrack.backend.dto.UsageDTO;
import com.neurotrack.backend.entity.UsageData;
import com.neurotrack.backend.repository.UsageRepository;
import com.neurotrack.backend.service.UsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UsageServiceImpl implements UsageService {

    private final UsageRepository usageRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public String analyzeUsage(UsageDTO dto) {

//        String url = "http://localhost:8000/predict";
//
//        Map<String, Object> request = new HashMap<>();
//        request.put("screenTime", dto.getScreenTime());
//        request.put("socialMediaTime", dto.getSocialMediaTime());
//        request.put("gamingTime", dto.getGamingTime());
//        request.put("sleepHours", dto.getSleepHours());
//        request.put("moodLevel", dto.getMoodLevel());
//        request.put("productivityLevel", dto.getProductivityLevel());
//        request.put("physicalActivity", dto.getPhysicalActivity());

//        Map response = restTemplate.postForObject(url, request, Map.class);

//        String risk = response.get("risk").toString();
        String risk = "MEDIUM"; // dummy value

        UsageData usage = UsageData.builder()
                .screenTime(dto.getScreenTime())
                .socialMediaTime(dto.getSocialMediaTime())
                .gamingTime(dto.getGamingTime())
                .sleepHours(dto.getSleepHours())
                .moodLevel(dto.getMoodLevel())
                .productivityLevel(dto.getProductivityLevel())
                .physicalActivity(dto.getPhysicalActivity())
                .riskLevel(risk)
                .createdAt(LocalDateTime.now())
                .build();

        usageRepository.save(usage);

        return risk;
    }
}