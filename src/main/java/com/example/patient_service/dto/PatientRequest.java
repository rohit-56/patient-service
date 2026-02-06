package com.example.patient_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class PatientRequest {

  @NotNull public String name;

  @NotBlank(message = "Email is Required")
  @Email(message = "Email should be unique")
  public String email;

  @NotNull @Email public String address;

  @NotNull public LocalDate birthdate;

  @NotNull public LocalDate registeredDate;

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getAddress() {
    return address;
  }

  public LocalDate getBirthdate() {
    return birthdate;
  }

  public LocalDate getRegisteredDate() {
    return registeredDate;
  }
}
