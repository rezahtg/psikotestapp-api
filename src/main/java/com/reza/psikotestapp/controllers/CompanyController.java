package com.reza.psikotestapp.controllers;

import com.reza.psikotestapp.models.Company;
import com.reza.psikotestapp.services.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @GetMapping("/company")
    public ResponseEntity<List<Company>> getAllCompany(){
        try {
            List<Company> result = companyService.getAllCompany();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Company company = companyService.getCompanyById(id);
        return ResponseEntity.ok(company);
    }

    @PostMapping("/company")
    public ResponseEntity<Company> CreateCompany(@RequestBody Company request){
        Company company = companyService.addCompany(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(company);
    }

    @PutMapping("/company/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company request){
        Company company = companyService.updateCompany(id, request);
        return ResponseEntity.ok(company);
    }

    @DeleteMapping("/company/{id}")
    public ResponseEntity<Void> deleteCompanyById(@PathVariable Long id){
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }
}
