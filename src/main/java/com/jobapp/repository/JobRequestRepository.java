package com.example.jobapp.repository;

import com.jobapp.model.JobRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRequestRepository extends JpaRepository<JobRequest, Long> {
}