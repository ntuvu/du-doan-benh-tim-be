package com.example.data_mining.models;

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
  private int cp;

  @Column(name = "trestbps")
  private int trestbps;

  @Column(name = "chol")
  private int chol;

  @Column(name = "fbs")
  private int fbs;

  @Column(name = "restecg")
  private int restecg;

  @Column(name = "thalach")
  private int thalach;

  @Column(name = "exang")
  private int exang;

  @Column(name = "oldpeak")
  private double oldpeak;

  @Column(name = "slope")
  private int slope;

  @Column(name = "ca")
  private int ca;

  @Column(name = "thal")
  private int thal;
}
