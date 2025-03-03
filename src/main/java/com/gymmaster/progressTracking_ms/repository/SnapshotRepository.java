package com.gymmaster.progressTracking_ms.repository;

import com.gymmaster.progressTracking_ms.model.Snapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SnapshotRepository extends JpaRepository<Snapshot, Long> {
    // TODO Custom methods for filtering between dates, maybe done by the FE(?)
    List<Snapshot> findByUserId(String userId);
}
