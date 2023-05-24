package com.reza.psikotestapp.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@ApiModel(description = "Sample Request Model Applicant")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Applicant {
    @ApiModelProperty("1L")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ApiModelProperty(value = "Name of the user", example = "John Doe")
    private String name;
    @ApiModelProperty("1997-11-05")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    @ApiModelProperty("Developer")
    private String position;
    @ManyToOne
    @ApiModelProperty("{ \"id\": 3, \"companyName\": \"Blibli\", \"companyAddress\": \"Jl.Buntu no.26 Jakarta Barat\" }")
    private Company company;

    @ManyToMany(mappedBy = "applicants")
    @JsonIgnore
    private List<Assessment> assessments;

    public void setBirthDate(String birthDateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(birthDateStr, formatter);
        this.birthDate = birthDate;
    }

    public Applicant(String name, LocalDate birthDate, String position) {
        this.name = name;
        this.birthDate = birthDate;
        this.position = position;
    }

    public Applicant(String name, LocalDate birthDate, String position, Company company) {
        this.name = name;
        this.birthDate = birthDate;
        this.position = position;
        this.company = company;
    }
}
