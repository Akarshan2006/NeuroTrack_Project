package com.neurotrack.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usage_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsageData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double screenTime;
    private double socialMediaTime;
    private double gamingTime;
    private double sleepHours;

    private int moodLevel;
    private int productivityLevel;

    private double physicalActivity;

    private String riskLevel;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}