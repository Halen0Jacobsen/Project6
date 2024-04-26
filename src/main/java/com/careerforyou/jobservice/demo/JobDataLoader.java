package com.careerforyou.jobservice.demo;

import com.careerforyou.jobservice.domain.Job;
import com.careerforyou.jobservice.domain.JobRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("TestData")
public class JobDataLoader {

    private final JobRepository jobRepository;

    public JobDataLoader(JobRepository jobRepository) {this.jobRepository = jobRepository; }

    @EventListener(ApplicationReadyEvent.class)
    public void loadJobTestData() {
        jobRepository.deleteAll();
        var job1 = Job.of("1234567891", "Test1", "Test1", "Test1", "Test1", "Test1" );
        var job2 = Job.of("1234567892", "Test2", "Test2", "Test2", "Test2", "Test2");
        jobRepository.saveAll(List.of(job1, job2));
    }
}
