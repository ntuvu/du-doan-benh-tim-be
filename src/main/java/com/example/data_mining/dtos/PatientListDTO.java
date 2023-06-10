package com.example.data_mining.dtos;

import com.example.data_mining.models.Patient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientListDTO {

  private int patientId;

  private String firstName;

  private String lastName;

  private String fullName;

  private String sex;

  private Double age;

  public PatientListDTO(Patient patient) {
    this.patientId = patient.getId();
    this.firstName = patient.getFirstName();
    this.lastName = patient.getLastName();
    this.fullName = patient.getLastName() + " " + patient.getFirstName();
    this.sex = patient.getSex() == 1 ? "Nam" : "Nữ";
    this.age = patient.getAge();
  }
}
