package com.example.jobapp.controller;

import com.jobapp.model.JobRequest;
import com.example.jobapp.service.JobRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/jobs")
public class JobRequestController {

    @Autowired
    private JobRequestService jobRequestService;

    @PostMapping
    public JobRequest createJobRequest(@RequestBody JobRequest jobRequest) {
        return jobRequestService.createJobRequest(jobRequest);
    }

    @GetMapping
    public List<JobRequest> getAllJobRequests() {
        return jobRequestService.getAllJobRequests();
    }

    @GetMapping("/{id}")
    public Optional<JobRequest> getJobRequestById(@PathVariable Long id) {
        return jobRequestService.getJobRequestById(id);
    }
}