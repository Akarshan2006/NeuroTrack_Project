package com.neurotrack.backend.controller;

import com.neurotrack.backend.dto.UsageDTO;
import com.neurotrack.backend.service.UsageService;
import com.neurotrack.backend.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usage")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UsageController {

    private final UsageService usageService;

    @PostMapping("/analyze")
    public ApiResponse<String> analyze(@RequestBody UsageDTO dto) {

        String result = usageService.analyzeUsage(dto);

        return ApiResponse.<String>builder()
                .message("Analysis completed successfully")
                .data(result)
                .status(200)
                .build();
    }
}