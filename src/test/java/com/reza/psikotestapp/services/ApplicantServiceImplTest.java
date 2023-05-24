package com.reza.psikotestapp.services;

import com.reza.psikotestapp.models.Applicant;
import com.reza.psikotestapp.repositories.ApplicantRepository;
import com.reza.psikotestapp.utils.UtilHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ApplicantServiceImplTest {

    @Mock
    private ApplicantRepository applicantRepository;

    private UtilHelper utilHelper;

    private ApplicantService applicantService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        applicantService = new ApplicantServiceImpl(applicantRepository, utilHelper);
    }

    @Test
    void testGetAllApplicant() {
        // Arrange
        List<Applicant> expectedApplicants = Arrays.asList(
                new Applicant(),
                new Applicant()
        );
        when(applicantRepository.findAll()).thenReturn(expectedApplicants);

        // Act
        List<Applicant> actualApplicants = applicantService.getAllApplicant();

        // Assert
        assertEquals(expectedApplicants, actualApplicants);
        verify(applicantRepository, times(1)).findAll();
    }

    @Test
    void testGetApplicantById_ValidId_ReturnsApplicant() {
        // Arrange
        Long applicantId = 1L;
        Applicant expectedApplicant = new Applicant();
        when(applicantRepository.findById(applicantId)).thenReturn(Optional.of(expectedApplicant));

        // Act
        Applicant actualApplicant = applicantService.getApplicantById(applicantId);

        // Assert
        assertEquals(expectedApplicant, actualApplicant);
        verify(applicantRepository, times(1)).findById(applicantId);
    }

    @Test
    void testGetApplicantById_InvalidId_ThrowsException() {
        // Arrange
        Long applicantId = 100L;
        when(applicantRepository.findById(applicantId)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = org.junit.jupiter.api.Assertions.assertThrows(
                RuntimeException.class,
                () -> applicantService.getApplicantById(applicantId)
        );
        assertEquals("Applicant not found", exception.getMessage());
        verify(applicantRepository, times(1)).findById(applicantId);
    }

    @Test
    void testAddApplicant_ReturnsSavedApplicant() {
        // Arrange
        Applicant applicant = new Applicant();
        Applicant savedApplicant = new Applicant();
        when(applicantRepository.save(applicant)).thenReturn(savedApplicant);

        // Act
        Applicant actualApplicant = applicantService.addApplicant(applicant);

        // Assert
        assertEquals(savedApplicant, actualApplicant);
        verify(applicantRepository, times(1)).save(applicant);
    }
}