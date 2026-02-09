package com.example.patient_service.controller;

import com.example.patient_service.dto.PatientRequest;
import com.example.patient_service.dto.PatientResponse;
import com.example.patient_service.service.impl.PatientServiceImpl;
import jakarta.validation.groups.Default;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

  private PatientServiceImpl patientService;

  public PatientController(PatientServiceImpl patientService) {
    this.patientService = patientService;
  }

  @GetMapping("/get-all")
  public ResponseEntity<List<PatientResponse>> getAllPatients() {
    List<PatientResponse> patientResponseList = patientService.getAllPatients();
    return new ResponseEntity<>(patientResponseList, HttpStatus.OK);
  }

  @GetMapping("/get/{email}")
  public ResponseEntity<PatientResponse> getPatientByEmail(@PathVariable String email) {
    PatientResponse patientResponse = patientService.getPatientByEmail(email);
    return new ResponseEntity<>(patientResponse, HttpStatus.OK);
  }

  @PostMapping("/create")
  public ResponseEntity<PatientResponse> createPatient(
      @Validated({Default.class}) @RequestBody PatientRequest patientRequest) {
    PatientResponse patientResponse = patientService.createPatient(patientRequest);
    return new ResponseEntity<>(patientResponse, HttpStatus.CREATED);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<PatientResponse> updatePatient(
      @PathVariable UUID id, @RequestBody PatientRequest patientRequest) {
    PatientResponse patientResponse = patientService.updatePatient(id, patientRequest);
    return new ResponseEntity<>(patientResponse, HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Void> deletePatient(@PathVariable UUID id) {
    patientService.deletePatient(id);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }
}
