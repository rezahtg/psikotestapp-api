package com.reza.psikotestapp.controllers;

import com.reza.psikotestapp.models.Applicant;
import com.reza.psikotestapp.services.ApplicantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Api(tags = "Applicant API")
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ApplicantController {

    private final ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }
//    @ApiOperation("Get All Aplicant")
    @GetMapping("/applicant")
    public ResponseEntity<List<Applicant>> getAllApplicant(){
        return new ResponseEntity<>(applicantService.getAllApplicant(), HttpStatus.OK);
    }

    @GetMapping("/applicant/{id}")
    public ResponseEntity<Applicant> getApplicantById(@PathVariable Long id){
        return ResponseEntity.ok(applicantService.getApplicantById(id));
    }

    @PostMapping("/applicant")
    public ResponseEntity<Applicant> createApplicant(@RequestBody Applicant request){
        Applicant applicant = applicantService.addApplicant(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(applicant);
    }

    @PutMapping("/applicant/{id}")
    public ResponseEntity<Applicant> updateApplicant(@PathVariable Long id, @RequestBody Applicant request){
        Applicant applicant = applicantService.updateApplicant(id, request);
        return ResponseEntity.ok(applicant);
    }

    @DeleteMapping("/applicant/{id}")
    public ResponseEntity<Void> deleteApplicantById(@PathVariable Long id){
        applicantService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
