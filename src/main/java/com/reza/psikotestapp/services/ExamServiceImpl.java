package com.reza.psikotestapp.services;

import com.reza.psikotestapp.models.Exam;
import com.reza.psikotestapp.repositories.ExamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;

    public ExamServiceImpl(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @Override
    public List<Exam> getAllExam() {
        return examRepository.findAll();
    }
}
