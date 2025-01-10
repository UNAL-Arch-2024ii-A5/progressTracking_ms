package com.gymmaster.progressTracking_ms.service;

import com.gymmaster.progressTracking_ms.dot.request.SnapshotRequestDot;
import com.gymmaster.progressTracking_ms.dot.response.ResponseDot;
import com.gymmaster.progressTracking_ms.dot.response.SnapshotResponseAdminDot;
import com.gymmaster.progressTracking_ms.dot.response.SnapshotResponseUserDot;
import com.gymmaster.progressTracking_ms.model.Snapshot;
import com.gymmaster.progressTracking_ms.repository.SnapshotRepository;
import com.gymmaster.progressTracking_ms.service.IProgressTrackingService;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgressTrackingServiceImpl implements IProgressTrackingService {

    @Autowired
    private SnapshotRepository snapshotRepository;


    //------------- CREATE ------------//
    @Override
    public ResponseDot createSnapshot(SnapshotRequestDot newSnapshot){

        Snapshot snapshot = new Snapshot();

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

        snapshotRepository.save(snapshot);

        return new ResponseDot("Snapshot created successfully", HttpStatus.OK);
    }

    //------------ READ -----------//
    @Override
    public SnapshotResponseUserDot getSnapshotByIdUser(Long id){

        Snapshot snapshot = snapshotRepository.findById(id).orElse(null);
        if (snapshot != null) {
            return new SnapshotResponseUserDot(
                    snapshot.getWeight(),
                    snapshot.getHeight(),
                    snapshot.getBodyFatPercentage(),
                    snapshot.getNeck(),
                    snapshot.getWaist(),
                    snapshot.getHip(),
                    snapshot.getChest(),
                    snapshot.getLeftArm(),
                    snapshot.getRightArm(),
                    snapshot.getLeftForearm(),
                    snapshot.getRightForearm(),
                    snapshot.getLeftThigh(),
                    snapshot.getRightThigh(),
                    snapshot.getLeftCalf(),
                    snapshot.getRightCalf(),
                    snapshot.getDate()
            );
        }
        return null; // TODO Throw an exception
    }

    @Override
    public SnapshotResponseAdminDot getSnapshotByIdAdmin(Long id){
        Snapshot snapshot = snapshotRepository.findById(id).orElse(null);

        if (snapshot != null) {
            return new SnapshotResponseAdminDot(
                    snapshot.getId(),
                    snapshot.getWeight(),
                    snapshot.getHeight(),
                    snapshot.getBodyFatPercentage(),
                    snapshot.getNeck(),
                    snapshot.getWaist(),
                    snapshot.getHip(),
                    snapshot.getChest(),
                    snapshot.getLeftArm(),
                    snapshot.getRightArm(),
                    snapshot.getLeftForearm(),
                    snapshot.getRightForearm(),
                    snapshot.getLeftThigh(),
                    snapshot.getRightThigh(),
                    snapshot.getLeftCalf(),
                    snapshot.getRightCalf(),
                    snapshot.getDate()
            );
        }
        return null; // TODO Throw an exception
    }

    @Override
    public List<SnapshotResponseUserDot> getAllSnapshotsUser(Long userId) {
        List<Snapshot> snapshots = snapshotRepository.findByUserId(userId);

        return snapshots.stream().map(snapshot -> new SnapshotResponseUserDot(
                snapshot.getWeight(),
                snapshot.getHeight(),
                snapshot.getBodyFatPercentage(),
                snapshot.getNeck(),
                snapshot.getWaist(),
                snapshot.getHip(),
                snapshot.getChest(),
                snapshot.getLeftArm(),
                snapshot.getRightArm(),
                snapshot.getLeftForearm(),
                snapshot.getRightForearm(),
                snapshot.getLeftThigh(),
                snapshot.getRightThigh(),
                snapshot.getLeftCalf(),
                snapshot.getRightCalf(),
                snapshot.getDate()
        )).collect(Collectors.toList());
    }

    @Override
    public List<SnapshotResponseAdminDot> getAllSnapshotsAdmin(){
        List<Snapshot> snapshots = snapshotRepository.findAll();

        return snapshots.stream().map(snapshot -> new SnapshotResponseAdminDot(
                snapshot.getId(),
                snapshot.getWeight(),
                snapshot.getHeight(),
                snapshot.getBodyFatPercentage(),
                snapshot.getNeck(),
                snapshot.getWaist(),
                snapshot.getHip(),
                snapshot.getChest(),
                snapshot.getLeftArm(),
                snapshot.getRightArm(),
                snapshot.getLeftForearm(),
                snapshot.getRightForearm(),
                snapshot.getLeftThigh(),
                snapshot.getRightThigh(),
                snapshot.getLeftCalf(),
                snapshot.getRightCalf(),
                snapshot.getDate()
        )).collect(Collectors.toList());
    }

    //-------------- UPDATE -----------//
    @Override
    public ResponseDot updateSnapshot(Long id, SnapshotRequestDot updatedSnapshot){
        Snapshot snapshot = snapshotRepository.findById(id).orElse(null);

        if (snapshot != null) {
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

            snapshotRepository.save(snapshot);

            return new ResponseDot("Snapshot updated successfully", HttpStatus.OK);
        }

        return new ResponseDot("Snapshot not found", HttpStatus.NOT_FOUND);
    }

    //------------- DELETE -------------//
    @Override
    public ResponseDot deleteSnapshot(Long id){
        Snapshot snapshot = snapshotRepository.findById(id).orElse(null);

        if (snapshot != null) {
            snapshotRepository.delete(snapshot);
            return new ResponseDot("Snapshot deleted successfully!", HttpStatus.OK);
        }
        return new ResponseDot("Snapshot not found", HttpStatus.NOT_FOUND);
    }
}
