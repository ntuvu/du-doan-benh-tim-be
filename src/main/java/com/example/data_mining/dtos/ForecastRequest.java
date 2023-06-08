package com.example.data_mining.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForecastRequest {

  private int age;

  private int sex;

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
}
