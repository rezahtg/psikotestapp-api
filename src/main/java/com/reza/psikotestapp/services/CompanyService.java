package com.reza.psikotestapp.services;

import com.reza.psikotestapp.models.Company;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface CompanyService {
    List<Company> getAllCompany();

    Company getCompanyById(Long id);

    Company addCompany(Company request);

    Company updateCompany(Long id, Company request);

    void deleteCompany(Long id);
}
