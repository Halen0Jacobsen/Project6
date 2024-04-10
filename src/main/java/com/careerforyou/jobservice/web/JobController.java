package com.careerforyou.jobservice.web;

import com.careerforyou.jobservice.domain.Job;
import com.careerforyou.jobservice.domain.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("job")
public class JobController {
    private final JobService jobService;
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping                                                   // base handler
    public Iterable<Job> get() {
        return jobService.viewJobList();
    }

    @GetMapping("{jobid}")
    public Job getByJobid(@PathVariable String jobid) {
        return jobService.viewJobDetails(jobid);
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED) // return 201 if created successfully
    public Job post(@Validated @RequestBody Job job)  { return  jobService.addJobToDatabase(job); }
    @DeleteMapping("{jobid}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // return 204 if a job is deleted successfully
    public void delete(@PathVariable String jobid) {
        jobService.removeJobFromDatabase(jobid);
    }

    @PutMapping("{jobid}")
    public Job put(@PathVariable String jobid, @Validated @RequestBody Job job) {
        return jobService.editJobDetails(jobid, job);
    }
}
