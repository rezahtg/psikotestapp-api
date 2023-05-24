package com.reza.psikotestapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String companyAddress;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Applicant> applicants;

    @ManyToMany(mappedBy = "companies", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Assessment> assessments;

    public Company(long id, String companyName, String companyAddress) {
        this.id = id;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }

    public Company(String companyName, String companyAddress) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;

    }
}
