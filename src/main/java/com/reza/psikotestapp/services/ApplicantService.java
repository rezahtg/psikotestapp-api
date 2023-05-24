package com.reza.psikotestapp.services;

import com.reza.psikotestapp.models.Applicant;

import java.util.List;

public interface ApplicantService {

    List<Applicant> getAllApplicant();

    Applicant getApplicantById(Long id);

    Applicant addApplicant(Applicant applicant);

    Applicant updateApplicant(Long id, Applicant applicant);

    void deleteById(Long id);

}
