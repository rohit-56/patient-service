package com.example.patient_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Patient {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public UUID Id;

  @NotNull public String name;

  @NotNull @Email public String email;

  @NotNull public String address;

  @NotNull public LocalDate birthDate;

  @NotNull public LocalDate registeredDate;

  public UUID getId() {
    return Id;
  }

  public void setId(UUID id) {
    Id = id;
  }

  public @NotNull String getName() {
    return name;
  }

  public void setName(@NotNull String name) {
    this.name = name;
  }

  public @NotNull String getEmail() {
    return email;
  }

  public void setEmail(@NotNull String email) {
    this.email = email;
  }

  public @NotNull String getAddress() {
    return address;
  }

  public void setAddress(@NotNull String address) {
    this.address = address;
  }

  public @NotNull LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(@NotNull LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public @NotNull LocalDate getRegisteredDate() {
    return registeredDate;
  }

  public void setRegisteredDate(@NotNull LocalDate registeredDate) {
    this.registeredDate = registeredDate;
  }
}
