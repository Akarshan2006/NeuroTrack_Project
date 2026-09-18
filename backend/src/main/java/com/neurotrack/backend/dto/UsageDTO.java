package com.neurotrack.backend.dto;


import lombok.Data;

@Data
public class UsageDTO {

    private double screenTime;
    private double socialMediaTime;
    private double gamingTime;
    private double sleepHours;
    private String email;

    private int moodLevel;
    private int productivityLevel;

    private double physicalActivity;
}
