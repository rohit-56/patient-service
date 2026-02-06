package com.example.patient_service.service.impl;

import com.example.patient_service.dto.PatientRequest;
import com.example.patient_service.dto.PatientResponse;
import com.example.patient_service.exception.EmailAlreadyExistException;
import com.example.patient_service.mapper.PatientMapper;
import com.example.patient_service.model.Patient;
import com.example.patient_service.repository.PatientRepository;
import com.example.patient_service.service.IPatientService;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements IPatientService {

  private PatientRepository patientRepository;

  private static Logger log = LoggerFactory.getLogger(PatientServiceImpl.class);

  public PatientServiceImpl(PatientRepository patientRepository) {
    this.patientRepository = patientRepository;
  }

  @Override
  public List<PatientResponse> getAllPatients() {
    List<Patient> patientList = patientRepository.findAll();
    List<PatientResponse> patientResponseList =
        patientList.stream().map(PatientMapper.fromPatientToPatientResponse).toList();
    return patientResponseList;
  }

  @Override
  public PatientResponse getPatientByEmail(String email) {
    Patient patient =
        patientRepository
            .findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Email Not Found"));
    PatientResponse patientResponse = PatientMapper.fromPatientToPatientResponse.apply(patient);
    return patientResponse;
  }

  @Override
  public PatientResponse createPatient(PatientRequest patientRequest) {
    Patient patient = PatientMapper.fromPatientRequestToPatient.apply(patientRequest);
    if (patientRepository.existsByEmail(patientRequest.getEmail())) {
      throw new EmailAlreadyExistException("Email Already Exist");
    }
    Patient createdPatient = patientRepository.save(patient);
    PatientResponse patientResponse =
        PatientMapper.fromPatientToPatientResponse.apply(createdPatient);
    return patientResponse;
  }

  @Override
  public PatientResponse updatePatient(UUID id, PatientRequest patientRequest) {
    Patient patient = PatientMapper.fromPatientRequestToPatient.apply(patientRequest);
    Patient createdPatient = patientRepository.save(patient);
    PatientResponse patientResponse =
        PatientMapper.fromPatientToPatientResponse.apply(createdPatient);
    return patientResponse;
  }

  @Override
  public void deletePatient(UUID id) {
    log.warn("Delete Patient Record from Database {}", id);
    patientRepository.deleteById(id);
  }
}
