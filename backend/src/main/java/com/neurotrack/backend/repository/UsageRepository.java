package com.neurotrack.backend.repository;


import com.neurotrack.backend.entity.UsageData;
import com.neurotrack.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsageRepository extends JpaRepository<UsageData, Long> {

    List<UsageData> findByUser(User user);
}