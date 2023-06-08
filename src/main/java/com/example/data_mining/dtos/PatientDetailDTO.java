package com.example.data_mining.dtos;

import com.example.data_mining.models.HealthIndicators;
import com.example.data_mining.models.Patient;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientDetailDTO {

  private int patientId;

  private String firstName;

  private String lastName;

  private String fullName;

  private String sex;

  private int age;

  private int cp;

  private int trestbps;

  private int chol;

  private int fbs;

  private int restecg;

  private int thalach;

  private int exang;

  private double oldpeak;

  private int slope;

  private int ca;

  private int thal;

  public PatientDetailDTO(Patient patient, HealthIndicators healthIndicators) {
    this.patientId = patient.getId();
    this.firstName = patient.getFirstName();
    this.lastName = patient.getLastName();
    this.fullName = patient.getLastName() + " " + patient.getFirstName();
    this.sex = patient.getSex() == 1 ? "Nam" : "Nữ";
    this.age = patient.getAge();
    this.cp = healthIndicators.getCp();
    this.trestbps = healthIndicators.getTrestbps();
    this.chol = healthIndicators.getChol();
    this.fbs = healthIndicators.getFbs();
    this.restecg = healthIndicators.getRestecg();
    this.thalach = healthIndicators.getThalach();
    this.exang = healthIndicators.getExang();
    this.oldpeak = healthIndicators.getOldpeak();
    this.slope = healthIndicators.getSlope();
    this.ca = healthIndicators.getCa();
    this.thal =  healthIndicators.getThal();
  }
}
