package com.gymmaster.progressTracking_ms.service;

import com.gymmaster.progressTracking_ms.dto.request.SnapshotDTO;
import com.gymmaster.progressTracking_ms.exception.NotFoundException;
import com.gymmaster.progressTracking_ms.model.Snapshot;
import com.gymmaster.progressTracking_ms.repository.SnapshotRepository;

import com.gymmaster.progressTracking_ms.utils.SnapshotMapper;
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

        Snapshot snapshot = new Snapshot();

        snapshot.setId(newSnapshot.getId());
        snapshot.setUserId(newSnapshot.getUserId());
        snapshot.setWeight(newSnapshot.getWeight());
        snapshot.setHeight(newSnapshot.getHeight());
        snapshot.setBodyFatPercentage(newSnapshot.getBodyFatPercentage());
        snapshot.setNeck(newSnapshot.getNeck());
        snapshot.setWaist(newSnapshot.getWaist());
        snapshot.setHip(newSnapshot.getHip());
        snapshot.setChest(newSnapshot.getChest());
        snapshot.setLeftArm(newSnapshot.getLeftArm());
        snapshot.setRightArm(newSnapshot.getRightArm());
        snapshot.setLeftForearm(newSnapshot.getLeftForearm());
        snapshot.setRightForearm(newSnapshot.getRightForearm());
        snapshot.setLeftThigh(newSnapshot.getLeftThigh());
        snapshot.setRightThigh(newSnapshot.getRightThigh());
        snapshot.setLeftCalf(newSnapshot.getLeftCalf());
        snapshot.setRightCalf(newSnapshot.getRightCalf());
        snapshot.setDate(newSnapshot.getDate());

        snapshot = snapshotRepository.save(snapshot);
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

        snapshot.setWeight(updatedSnapshot.getWeight());
        snapshot.setHeight(updatedSnapshot.getHeight());
        snapshot.setBodyFatPercentage(updatedSnapshot.getBodyFatPercentage());
        snapshot.setNeck(updatedSnapshot.getNeck());
        snapshot.setWaist(updatedSnapshot.getWaist());
        snapshot.setHip(updatedSnapshot.getHip());
        snapshot.setChest(updatedSnapshot.getChest());
        snapshot.setLeftArm(updatedSnapshot.getLeftArm());
        snapshot.setRightArm(updatedSnapshot.getRightArm());
        snapshot.setLeftForearm(updatedSnapshot.getLeftForearm());
        snapshot.setRightForearm(updatedSnapshot.getRightForearm());
        snapshot.setLeftThigh(updatedSnapshot.getLeftThigh());
        snapshot.setRightThigh(updatedSnapshot.getRightThigh());
        snapshot.setLeftCalf(updatedSnapshot.getLeftCalf());
        snapshot.setRightCalf(updatedSnapshot.getRightCalf());
        snapshot.setDate(updatedSnapshot.getDate());

        snapshot = snapshotRepository.save(snapshot);

        return SnapshotMapper.toDTO(snapshot);

    }

    //------------- DELETE -------------//
    @Override
    public void deleteSnapshot(Long id) {
        if (!snapshotRepository.existsById(id)) {
            throw new NotFoundException("Snapshot not found with ID: " + id);
        }
        snapshotRepository.deleteById(id);
    }
}
