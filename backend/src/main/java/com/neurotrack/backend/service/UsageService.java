package com.neurotrack.backend.service;

import com.neurotrack.backend.dto.UsageDTO;

public interface UsageService {

    String analyzeUsage(UsageDTO dto);
}