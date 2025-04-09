package com.example.jobapp.service;

import com.jobapp.model.JobRequest;
import com.example.jobapp.repository.JobRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobRequestService {

    @Autowired
    private JobRequestRepository jobRequestRepository;

    public JobRequest createJobRequest(JobRequest jobRequest) {
        return jobRequestRepository.save(jobRequest);
    }

    public List<JobRequest> getAllJobRequests() {
        return jobRequestRepository.findAll();
    }

    public Optional<JobRequest> getJobRequestById(Long id) {
        return jobRequestRepository.findById(id);
    }
}