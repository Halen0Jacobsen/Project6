package com.careerforyou.jobservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.annotation.*;

import java.time.Instant;


public record Job (

        @Id
        Long id,        // Primary key

        @NotBlank(message = "The Job ID must be defined.")
        @Pattern(
                regexp = "^([0-9])$",
                message = "The Job ID format must be valid"
        )
        String jobid,
        @NotBlank(message = "The Job title must be defined.")

        String title,
        @NotBlank(message = "The Job description must be defined.")

        String description,
        @NotBlank(message = "The Company Name must be defined")
        String companyname,

        String skill1,

        String skill2,

        @CreatedDate
        Instant createdDate,

        @LastModifiedDate
        Instant lastModifiedDate,

        @Version
        int version
) {
        public static Job of(
//                Long Id,
                String jobid,
                String title,
                String description,
                String companyname,
                String skill1,
                String skill2
        ) {

                return new Job(null, jobid, title, description, companyname, skill1, skill2, null, null, 0);
        }
}
