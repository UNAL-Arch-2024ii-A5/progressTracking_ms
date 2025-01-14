package com.gymmaster.progressTracking_ms.utils;

import com.gymmaster.progressTracking_ms.model.Snapshot;
import com.gymmaster.progressTracking_ms.dto.request.SnapshotDTO;

public class SnapshotMapper {

    public static SnapshotDTO toDTO(Snapshot snapshot) {
        SnapshotDTO dto = new SnapshotDTO();

        dto.setId(snapshot.getId());
        dto.setUserId(snapshot.getUserId());
        dto.setWeight(snapshot.getWeight());
        dto.setHeight(snapshot.getHeight());
        dto.setBodyFatPercentage(snapshot.getBodyFatPercentage());
        dto.setNeck(snapshot.getNeck());
        dto.setWaist(snapshot.getWaist());
        dto.setHip(snapshot.getHip());
        dto.setChest(snapshot.getChest());
        dto.setLeftArm(snapshot.getLeftArm());
        dto.setRightArm(snapshot.getRightArm());
        dto.setLeftForearm(snapshot.getLeftForearm());
        dto.setRightForearm(snapshot.getRightForearm());
        dto.setLeftThigh(snapshot.getLeftThigh());
        dto.setRightThigh(snapshot.getRightThigh());
        dto.setLeftCalf(snapshot.getLeftCalf());
        dto.setRightCalf(snapshot.getRightCalf());
        dto.setDate(snapshot.getDate());
        return dto;
    }

    public static Snapshot toEntity(SnapshotDTO dto) {
        Snapshot snapshot = new Snapshot();

        snapshot.setId(dto.getId());
        snapshot.setUserId(dto.getUserId());
        snapshot.setWeight(dto.getWeight());
        snapshot.setHeight(dto.getHeight());
        snapshot.setBodyFatPercentage(dto.getBodyFatPercentage());
        snapshot.setNeck(dto.getNeck());
        snapshot.setWaist(dto.getWaist());
        snapshot.setHip(dto.getHip());
        snapshot.setChest(dto.getChest());
        snapshot.setLeftArm(dto.getLeftArm());
        snapshot.setRightArm(dto.getRightArm());
        snapshot.setLeftForearm(dto.getLeftForearm());
        snapshot.setRightForearm(dto.getRightForearm());
        snapshot.setLeftThigh(dto.getLeftThigh());
        snapshot.setRightThigh(dto.getRightThigh());
        snapshot.setLeftCalf(dto.getLeftCalf());
        snapshot.setRightCalf(dto.getRightCalf());
        snapshot.setDate(dto.getDate());
        return snapshot;
    }
}
