package com.careerforyou.jobservice.domain;

import com.careerforyou.jobservice.domain.Job;
import com.careerforyou.jobservice.domain.JobAlreadyExistsException;
import com.careerforyou.jobservice.domain.JobNotFoundException;
import com.careerforyou.jobservice.domain.JobRepository;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    private final JobRepository jobRepository; // Set up repository

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Iterable<Job> viewJobList() {
        return jobRepository.findAll();
    }

    public Job viewJobDetails(String jobid) {
        return jobRepository.findByJobid(jobid)
                .orElseThrow(() -> new JobNotFoundException(jobid));
    }

    public Job addJobToDatabase(Job job) {
        if (jobRepository.existsByJobid(job.jobid())) {
            throw new JobAlreadyExistsException(job.jobid());
        }
        return  jobRepository.save(job);
    }

    public void removeJobFromDatabase(String jobid) {
        jobRepository.deleteByJobid(jobid);
    }

    public Job editJobDetails(String jobid, Job job) {
        return jobRepository.findByJobid(jobid)
                .map(existingJob -> {
                    var jobToUpdate = new Job(
                            existingJob.id(),
                            existingJob.jobid(),
                            job.title(),
                            job.description(),
                            job.companyname(),
                            job.skill1(),
                            job.skill2(),
                            existingJob.createdDate(),
                            existingJob.lastModifiedDate(),
                            existingJob.version()
                    );
                    return  jobRepository.save(jobToUpdate);

                })
                .orElseGet(() -> addJobToDatabase(job));
    }
}
