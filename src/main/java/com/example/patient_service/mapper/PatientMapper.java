package com.example.patient_service.mapper;

import com.example.patient_service.dto.PatientRequest;
import com.example.patient_service.dto.PatientResponse;
import com.example.patient_service.model.Patient;
import java.util.function.Function;

public class PatientMapper {

  public static final Function<PatientRequest, Patient> fromPatientRequestToPatient =
      patientRequest -> {
        Patient patient = new Patient();
        patient.setName(patientRequest.getName());
        patient.setEmail(patientRequest.getEmail());
        patient.setAddress(patientRequest.getAddress());
        patient.setBirthDate(patientRequest.getBirthdate());
        patient.setRegisteredDate(patientRequest.getRegisteredDate());
        return patient;
      };

  public static final Function<Patient, PatientResponse> fromPatientToPatientResponse =
      patient -> {
        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setId(patient.getId());
        patientResponse.setName(patient.getName());
        patientResponse.setEmail(patient.getEmail());
        patientResponse.setAddress(patient.getAddress());
        patientResponse.setBirthdate(patient.getBirthDate().toString());
        return patientResponse;
      };
}
