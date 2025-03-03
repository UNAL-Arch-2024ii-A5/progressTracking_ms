package com.gymmaster.progressTracking_ms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "snapshots")
public class Snapshot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private String userId;
    private Double weight;
    private Double height;

    @Column(name = "body_fat_percentage")
    private Double bodyFatPercentage;
    private Double neck;
    private Double waist;
    private Double hip;
    private Double chest;

    @Column(name = "left_arm")
    private Double leftArm;
    @Column(name = "right_arm")
    private Double rightArm;
    @Column(name = "left_forearm")
    private Double leftForearm;
    @Column(name = "right_forearm")
    private Double rightForearm;
    @Column(name = "left_thigh")
    private Double leftThigh;
    @Column(name = "right_thigh")
    private Double rightThigh;
    @Column(name = "left_calf")
    private Double leftCalf;
    @Column(name = "right_calf")
    private Double rightCalf;
    private LocalDate date; // When were the measurements taken
}