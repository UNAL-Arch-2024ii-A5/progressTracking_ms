package com.gymmaster.progressTracking_ms.service;

import com.gymmaster.progressTracking_ms.dot.response.ResponseDot;
import com.gymmaster.progressTracking_ms.dot.response.SnapshotResponseUserDot;
import com.gymmaster.progressTracking_ms.dot.response.SnapshotResponseAdminDot;
import com.gymmaster.progressTracking_ms.dot.request.SnapshotRequestDot;

import java.util.List;


public interface IProgressTrackingService {
    // <<<< CRUD OP.
    //------CREATE-------//
    public ResponseDot createSnapshot(SnapshotRequestDot newSnapshot);

    //------READ---------//
    public SnapshotResponseUserDot getSnapshotByIdUser(Long Id);
    public SnapshotResponseAdminDot getSnapshotByIdAdmin(Long Id);
    public List<SnapshotResponseUserDot> getAllSnapshotsUser(Long userId);
    public List<SnapshotResponseAdminDot> getAllSnapshotsAdmin();

    //------UPDATE-------//
    public ResponseDot updateSnapshot(Long id, SnapshotRequestDot updatedSnapshot);

    //------DELETE-------//
    public ResponseDot deleteSnapshot(Long id);

}