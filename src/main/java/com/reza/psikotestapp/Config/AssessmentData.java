package com.reza.psikotestapp.Config;

import com.reza.psikotestapp.models.Assessment;
import com.reza.psikotestapp.models.AssessmentType;
import com.reza.psikotestapp.models.Company;
import com.reza.psikotestapp.repositories.ApplicantRepository;
import com.reza.psikotestapp.repositories.AssessmentRepository;
import com.reza.psikotestapp.repositories.CompanyRepository;
import com.reza.psikotestapp.utils.UtilHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class AssessmentData implements ApplicationListener<ContextRefreshedEvent> {

    private final ApplicantRepository applicantRepository;

    private final CompanyRepository companyRepository;

    private final AssessmentRepository assessmentRepository;

    private final UtilHelper utilHelper;

    public AssessmentData(ApplicantRepository applicantRepository, CompanyRepository companyRepository, AssessmentRepository assessmentRepository, UtilHelper utilHelper) {
        this.applicantRepository = applicantRepository;
        this.companyRepository = companyRepository;
        this.assessmentRepository = assessmentRepository;
        this.utilHelper = utilHelper;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        assessmentRepository.saveAll(createBoostrapAssessment());
        log.info(String.format("%s - Bootstrap Assement Data Finsih", utilHelper.dtNow()));
    }

    private List<Assessment> createBoostrapAssessment(){
        log.info(String.format("%s - Bootstrap Assessment Data Started", utilHelper.dtNow()));
        List<Assessment> assessments = new ArrayList<>(2);
        Assessment assessmentReza = new Assessment();
        assessmentReza.setAssessmentType(AssessmentType.PERSONALITY);
        assessmentReza.setStartTime("2023-05-30T08:00:00");
        assessmentReza.setEndTime("2023-06-03T23:59:00");
//        assessmentReza.getCompanies().add(new Company(4L, "Shopee", "jl.kakung 28 Sumatera"));
        assessmentReza.getCompanies().add(companyRepository.findById(1L).get());
        assessmentReza.getApplicants().add(applicantRepository.findById(1L).get());
        assessments.add(assessmentReza);

        Assessment assessmentJohn = new Assessment();
        assessmentJohn.setAssessmentType(AssessmentType.TECHNICAL);
        assessmentJohn.setStartTime("2023-05-30T08:00:00");
        assessmentJohn.setEndTime("2023-06-03T23:59:00");
        assessmentJohn.getCompanies().add(companyRepository.findById(2L).get());
        assessmentJohn.getApplicants().add(applicantRepository.findById(2L).get());
        assessments.add(assessmentJohn);
        return assessments;
    }



}
