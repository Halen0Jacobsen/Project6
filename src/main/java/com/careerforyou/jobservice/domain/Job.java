package com.careerforyou.jobservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


public record Job (

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

        String skill2
) {}
