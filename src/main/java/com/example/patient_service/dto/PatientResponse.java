package com.example.patient_service.dto;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public class PatientResponse {

  @NotNull public UUID id;

  @NotNull public String name;

  @NotNull public String email;

  @NotNull public String address;

  @NotNull public String birthdate;

  public void setId(@NotNull UUID id) {
    this.id = id;
  }

  public void setName(@NotNull String name) {
    this.name = name;
  }

  public void setEmail(@NotNull String email) {
    this.email = email;
  }

  public void setAddress(@NotNull String address) {
    this.address = address;
  }

  public void setBirthdate(@NotNull String birthdate) {
    this.birthdate = birthdate;
  }
}
