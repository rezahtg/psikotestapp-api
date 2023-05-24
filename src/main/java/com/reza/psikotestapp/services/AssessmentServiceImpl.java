package com.reza.psikotestapp.services;

import com.reza.psikotestapp.models.Assessment;
import com.reza.psikotestapp.repositories.AssessmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentServiceImpl implements AssessmentService {
    private final AssessmentRepository assessmentRepository;

    public AssessmentServiceImpl(AssessmentRepository assessmentRepository) {
        this.assessmentRepository = assessmentRepository;
    }

    @Override
    public List<Assessment> getAllAssessment() {
        return assessmentRepository.findAll();
    }
}
