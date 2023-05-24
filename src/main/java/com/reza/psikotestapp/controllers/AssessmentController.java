package com.reza.psikotestapp.controllers;

import com.reza.psikotestapp.models.Assessment;
import com.reza.psikotestapp.services.AssessmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AssessmentController {

    private final AssessmentService assessmentService;

    public AssessmentController(AssessmentService assessmentService) {
        this.assessmentService = assessmentService;
    }

    @GetMapping("/assessment")
    public ResponseEntity<List<Assessment>> getAllAssessment(){
        return new ResponseEntity<>(assessmentService.getAllAssessment(), HttpStatus.OK);
    }

}
