package com.example.data_mining.models;

import com.example.data_mining.dtos.CreatePatientRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "health_indicators")
public class HealthIndicators {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "cp")
  private Double cp;

  @Column(name = "trestbps")
  private Double trestbps;

  @Column(name = "chol")
  private Double chol;

  @Column(name = "fbs")
  private Double fbs;

  @Column(name = "restecg")
  private Double restecg;

  @Column(name = "thalach")
  private Double thalach;

  @Column(name = "exang")
  private Double exang;

  @Column(name = "oldpeak")
  private Double oldpeak;

  @Column(name = "slope")
  private Double slope;

  @Column(name = "ca")
  private Double ca;

  @Column(name = "thal")
  private Double thal;

  @Column(name = "target")
  private Double target;

  public HealthIndicators(CreatePatientRequest request) {
    this.cp = request.getCp();
    this.trestbps = request.getTrestbps();
    this.chol = request.getChol();
    this.fbs = request.getFbs();
    this.restecg = request.getRestecg();
    this.thalach = request.getThalach();
    this.exang = request.getExang();
    this.oldpeak = request.getOldpeak();
    this.slope = request.getSlope();
    this.ca = request.getCa();
    this.thal = request.getThal();
  }

  public void replace(CreatePatientRequest request) {
    this.cp = request.getCp();
    this.trestbps = request.getTrestbps();
    this.chol = request.getChol();
    this.fbs = request.getFbs();
    this.restecg = request.getRestecg();
    this.thalach = request.getThalach();
    this.exang = request.getExang();
    this.oldpeak = request.getOldpeak();
    this.slope = request.getSlope();
    this.ca = request.getCa();
    this.thal = request.getThal();
  }
}
