package com.gymmaster.progressTracking_ms.controller;

import com.gymmaster.progressTracking_ms.dto.request.SnapshotDTO;
import com.gymmaster.progressTracking_ms.service.IProgressTrackingService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/snapshots")
public class progressTrackingController {

    @Autowired
    private IProgressTrackingService progressTrackingService;

    @PostMapping
    public ResponseEntity<SnapshotDTO> createSnapshot(@RequestBody SnapshotDTO newSnapshot){
        SnapshotDTO createdSnapshot = progressTrackingService.createSnapshot(newSnapshot);
        return new ResponseEntity<>(createdSnapshot, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SnapshotDTO> getSnapshotById(@PathVariable Long id){
        SnapshotDTO snapshotDTO = progressTrackingService.getSnapshotById(id);
        return ResponseEntity.ok(snapshotDTO);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<SnapshotDTO>> getAllSnapshotsUser(@PathVariable Long userId){
        List<SnapshotDTO> snapshotDTOList = progressTrackingService.getAllSnapshotsUser(userId);
        return ResponseEntity.ok(snapshotDTOList);
    }

    @GetMapping
    public ResponseEntity<List<SnapshotDTO>> getAllSnapshots(){
        List<SnapshotDTO> snapshotDTOList = progressTrackingService.getAllSnapshots();
        return ResponseEntity.ok(snapshotDTOList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SnapshotDTO> updateSnapshot(@PathVariable Long id, @RequestBody SnapshotDTO snapshotDTO){
        SnapshotDTO updatedSnapshot = progressTrackingService.updateSnapshot(id, snapshotDTO);
        return ResponseEntity.ok(updatedSnapshot);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSnapshot(@PathVariable Long id){
        progressTrackingService.deleteSnapshot(id);
        return ResponseEntity.noContent().build();
    }
}