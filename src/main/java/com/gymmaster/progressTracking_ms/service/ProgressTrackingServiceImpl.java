package com.gymmaster.progressTracking_ms.service;

import com.gymmaster.progressTracking_ms.dto.request.SnapshotDTO;
import com.gymmaster.progressTracking_ms.dto.response.ResponseDTO;
import com.gymmaster.progressTracking_ms.exception.NotFoundException;
import com.gymmaster.progressTracking_ms.model.Snapshot;
import com.gymmaster.progressTracking_ms.repository.SnapshotRepository;

import com.gymmaster.progressTracking_ms.utils.SnapshotMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgressTrackingServiceImpl implements IProgressTrackingService {

    @Autowired
    private SnapshotRepository snapshotRepository;


    //------------- CREATE ------------//
    @Override
    public SnapshotDTO createSnapshot(SnapshotDTO newSnapshot){

        Snapshot snapshot = SnapshotMapper.toEntity(newSnapshot);
        snapshotRepository.save(snapshot);
        return SnapshotMapper.toDTO(snapshot);
    }

    //------------ READ -----------//
    @Override
    public SnapshotDTO getSnapshotById(Long id){

        Snapshot snapshot = snapshotRepository.findById(id).orElseThrow(() -> new NotFoundException("Snapshot not found with ID: " + id));
        return SnapshotMapper.toDTO(snapshot);
    }

    @Override
    public List<SnapshotDTO> getAllSnapshotsUser(Long userId) {
        List<Snapshot> snapshots = snapshotRepository.findByUserId(userId);

        return snapshots.stream().map(SnapshotMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<SnapshotDTO> getAllSnapshots(){
        List<Snapshot> snapshots = snapshotRepository.findAll();

        return snapshots.stream().map(SnapshotMapper::toDTO).collect(Collectors.toList());
    }

    //-------------- UPDATE -----------//
    @Override
    public SnapshotDTO updateSnapshot(Long id, SnapshotDTO updatedSnapshot){
        Snapshot snapshot = snapshotRepository.findById(id).orElseThrow(() -> new NotFoundException("Snapshot not found with ID: " + id));
        Snapshot snapshot_1 = SnapshotMapper.toEntity(updatedSnapshot);
        snapshot_1.setId(snapshot.getId());

        return SnapshotMapper.toDTO(snapshotRepository.save(snapshot_1));

    }

    //------------- DELETE -------------//
    @Override
    public ResponseDTO deleteSnapshot(Long id) {
        if (!snapshotRepository.existsById(id)) {
            throw new NotFoundException("Snapshot not found with ID: " + id);
        }
        snapshotRepository.deleteById(id);
        return new ResponseDTO("Snapshot deleted successfully", HttpStatus.NO_CONTENT);
    }
}
