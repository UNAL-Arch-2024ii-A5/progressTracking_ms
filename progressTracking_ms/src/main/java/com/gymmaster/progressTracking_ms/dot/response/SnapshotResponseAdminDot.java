package com.gymmaster.progressTracking_ms.dot.response;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SnapshotResponseAdminDot {
    private Long userId;
    private Double weight;
    private Double height;
    private Double bodyFatPercentage;
    private Double neck;
    private Double waist;
    private Double hip;
    private Double chest;
    private Double leftArm;
    private Double rightArm;
    private Double leftForearm;
    private Double rightForearm;
    private Double leftThigh;
    private Double rightThigh;
    private Double leftCalf;
    private Double rightCalf;
    private LocalDate date; // When were the measurements taken
}
