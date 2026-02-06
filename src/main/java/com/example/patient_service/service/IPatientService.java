package com.example.patient_service.service;

import com.example.patient_service.dto.PatientRequest;
import com.example.patient_service.dto.PatientResponse;
import java.util.List;
import java.util.UUID;

public interface IPatientService {

  List<PatientResponse> getAllPatients();

  PatientResponse getPatientByEmail(String email);

  PatientResponse createPatient(PatientRequest patientRequest);

  PatientResponse updatePatient(UUID id, PatientRequest patientRequest);

  void deletePatient(UUID id);
}
