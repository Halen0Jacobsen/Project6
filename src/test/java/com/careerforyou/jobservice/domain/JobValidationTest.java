package com.careerforyou.jobservice.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class JobValidationTest {

    private static Validator validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

    }

    @Test
    void whenAllFieldsCorrectThenValidationSucceeds() {
        var job = Job.of("1", "Dev", "Dev", "Dev", "Devl1", "Dev2");
        Set<ConstraintViolation<Job>> violations = validator.validate(job);
        assertThat(violations).isEmpty();
    }

    @Test
    void whenJobidDefinedButIncorrectThenValidationFails(){
        var job = Job.of("one","Dev", "Dev", "Dev", "Skill1", "Skill2");
        Set<ConstraintViolation<Job>> violations = validator.validate(job);
        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage())
                .isEqualTo("The Job ID format must be valid");
    }
}
