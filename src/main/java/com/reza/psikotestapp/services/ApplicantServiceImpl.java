package com.reza.psikotestapp.services;

import com.reza.psikotestapp.models.Applicant;
import com.reza.psikotestapp.repositories.ApplicantRepository;
import com.reza.psikotestapp.utils.UtilHelper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApplicantServiceImpl implements ApplicantService {

    private final ApplicantRepository applicantRepository;

    private final UtilHelper utilHelper;

    public ApplicantServiceImpl(ApplicantRepository applicantRepository, UtilHelper utilHelper) {
        this.applicantRepository = applicantRepository;
        this.utilHelper = utilHelper;
    }

    @Override
    public List<Applicant> getAllApplicant() {
        return applicantRepository.findAll();
    }

    @Override
    public Applicant getApplicantById(Long id) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));

        return applicant;
    }

    @Override
    public Applicant addApplicant(Applicant applicant) {
        Applicant applicantRequest = new Applicant();
        applicantRequest.setName(applicant.getName());
        applicantRequest.setBirthDate(utilHelper.birthDateStr(applicant.getBirthDate()));
        applicantRequest.setPosition(applicant.getPosition());
        applicantRequest.setCompany(applicant.getCompany());
        return applicantRepository.save(applicantRequest);
    }

    @Override
    public Applicant updateApplicant(Long id, Applicant applicant) {
        Applicant applicant1 = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));
        applicant1.setName(applicant.getName());
        applicant1.setBirthDate(utilHelper.birthDateStr(applicant.getBirthDate()));
        applicant1.setPosition(applicant.getPosition());
        applicant1.setCompany(applicant.getCompany());
        return applicantRepository.save(applicant1);
    }

    @Override
    public void deleteById(Long id) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Applicant not found"));
        applicantRepository.delete(applicant);
    }
}
