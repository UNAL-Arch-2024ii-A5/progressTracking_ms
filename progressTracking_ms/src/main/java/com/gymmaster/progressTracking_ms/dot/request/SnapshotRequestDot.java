package com.gymmaster.progressTracking_ms.dot.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.PastOrPresent;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SnapshotRequestDot {

    @NotNull(message = "Weight is required.")
    @Positive(message = "Weight must be a positive number.")
    private Double weight;

    @NotNull(message = "Height is required.")
    @Positive(message = "Height must be a positive number.")
    private Double height;

    @PositiveOrZero(message = "Body fat percentage must be zero or positive.")
    private Double bodyFatPercentage;

    @PositiveOrZero(message = "Neck size must be zero or positive.")
    private Double neck;

    @PositiveOrZero(message = "Waist size must be zero or positive.")
    private Double waist;

    @PositiveOrZero(message = "Hip size must be zero or positive.")
    private Double hip;

    @PositiveOrZero(message = "Chest size must be zero or positive.")
    private Double chest;

    @PositiveOrZero(message = "Left arm size must be zero or positive.")
    private Double leftArm;

    @PositiveOrZero(message = "Right arm size must be zero or positive.")
    private Double rightArm;

    @PositiveOrZero(message = "Left forearm size must be zero or positive.")
    private Double leftForearm;

    @PositiveOrZero(message = "Right forearm size must be zero or positive.")
    private Double rightForearm;

    @PositiveOrZero(message = "Left thigh size must be zero or positive.")
    private Double leftThigh;

    @PositiveOrZero(message = "Right thigh size must be zero or positive.")
    private Double rightThigh;

    @PositiveOrZero(message = "Left calf size must be zero or positive.")
    private Double leftCalf;

    @PositiveOrZero(message = "Right calf size must be zero or positive.")
    private Double rightCalf;

    @NotNull(message = "Date is required.")
    @PastOrPresent(message = "Date must be in the past or present.")
    private LocalDate date; // When the measurements where taken
}
