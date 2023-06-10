package com.example.data_mining.models;

import com.example.data_mining.dtos.CreatePatientRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "patient")
public class Patient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "sex", nullable = false)
  private Double sex;

  @Column(name = "age", nullable = false)
  private Double age;

  @Column(name = "health_indicators_id")
  private Integer healthIndicatorsId;

  public Patient(CreatePatientRequest request, Integer healthIndicatorsId) {
    this.firstName = request.getFirstName();
    this.lastName = request.getLastName();
    this.age = request.getAge();
    this.sex = request.getSex();
    this.healthIndicatorsId = healthIndicatorsId;
  }

  public void replace(CreatePatientRequest request) {
    this.firstName = request.getFirstName();
    this.lastName = request.getLastName();
    this.age = request.getAge();
    this.sex = request.getSex();
  }
}
