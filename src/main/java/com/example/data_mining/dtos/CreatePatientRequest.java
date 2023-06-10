package com.example.data_mining.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePatientRequest {

  private String firstName;

  private String lastName;

  private Double sex;

  private Double age;

  private Double cp;

  private Double trestbps;

  private Double chol;

  private Double fbs;

  private Double restecg;

  private Double thalach;

  private Double exang;

  private Double oldpeak;

  private Double slope;

  private Double ca;

  private Double thal;
}
