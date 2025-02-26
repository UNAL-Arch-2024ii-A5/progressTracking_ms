package com.gymmaster.progressTracking_ms.service;

import com.gymmaster.progressTracking_ms.dto.request.SnapshotDTO;
import com.gymmaster.progressTracking_ms.dto.response.ResponseDTO;

import java.util.List;


public interface IProgressTrackingService {
    // <<<< CRUD OP.
    //------CREATE-------//
    public SnapshotDTO createSnapshot(SnapshotDTO newSnapshot);

    //------READ---------//
    public SnapshotDTO getSnapshotById(Long Id);
    public List<SnapshotDTO> getAllSnapshotsUser(Long userId);
    public List<SnapshotDTO> getAllSnapshots();

    //------UPDATE-------//
    public SnapshotDTO updateSnapshot(Long id, SnapshotDTO updatedSnapshot);

    //------DELETE-------//
    public ResponseDTO deleteSnapshot(Long id);

}