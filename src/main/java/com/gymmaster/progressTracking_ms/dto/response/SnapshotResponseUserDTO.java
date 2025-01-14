package com.gymmaster.progressTracking_ms.dto.response;

import java.time.LocalDate;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SnapshotResponseUserDTO {

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
