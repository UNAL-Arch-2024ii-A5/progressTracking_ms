package com.gymmaster.progressTracking_ms.controller;

import com.gymmaster.progressTracking_ms.dot.request.SnapshotRequestDot;
import com.gymmaster.progressTracking_ms.dot.response.ResponseDot;
import com.gymmaster.progressTracking_ms.service.IProgressTrackingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/snapshots")
public class progressTrackingController {

    @Autowired
    private IProgressTrackingService progressTrackingService;


    @GetMapping

}