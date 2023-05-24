package com.reza.psikotestapp.services;

import com.reza.psikotestapp.models.Company;
import com.reza.psikotestapp.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));
    }

    @Override
    public Company addCompany(Company request) {
        Company comp = new Company();
        comp.setCompanyName(request.getCompanyName());
        comp.setCompanyAddress(request.getCompanyAddress());
        return companyRepository.save(comp);
    }

    @Override
    public Company updateCompany(Long id, Company request) {
        Company comp = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));
        comp.setCompanyName(request.getCompanyName());
        comp.setCompanyAddress(request.getCompanyAddress());
        return companyRepository.save(comp);
    }

    @Override
    public void deleteCompany(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));
        companyRepository.delete(company);
    }
}
