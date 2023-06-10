package com.example.data_mining.dtos;

import com.example.data_mining.models.HealthIndicators;
import com.example.data_mining.models.Patient;
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

  private Double age;

  private Double cp;

  private String cpName; // loại đau ngực

  private Double trestbps;

  private Double chol;

  private Double fbs;

  private String fbsName;

  private Double restecg;

  private String restecgName;

  private Double thalach;

  private Double exang;

  private String exangName;

  private double oldpeak;

  private Double slope;

  private Double ca;

  private Double thal;

  private Double target;

  private String targetName;

  public PatientDetailDTO(Patient patient, HealthIndicators healthIndicators) {
    this.patientId = patient.getId();
    this.firstName = patient.getFirstName();
    this.lastName = patient.getLastName();
    this.fullName = patient.getLastName() + " " + patient.getFirstName();
    this.sex = patient.getSex() == 1 ? "Nam" : "Nữ";
    this.age = patient.getAge();
    this.cp = healthIndicators.getCp();
    this.cpName = switch (healthIndicators.getCp().intValue()) {
      case 1 -> "Đau thắt ngực điển hình";
      case 2 -> "Đau thắt ngực không điển hình";
      case 3 -> "Không đau thắt ngực";
      case 4 -> "Không có triệu chứng";
      default -> null;
    };
    this.trestbps = healthIndicators.getTrestbps();
    this.chol = healthIndicators.getChol();
    this.fbs = healthIndicators.getFbs();
    this.fbsName = switch (healthIndicators.getFbs().intValue()) {
      case 0 -> "Thấp hơn 120 mg/dl";
      case 1 -> "Cao hơn 120 mg/dl";
      default -> null;
    };
    this.restecg = healthIndicators.getRestecg();
    this.restecgName = switch (healthIndicators.getRestecg().intValue()) {
      case 0 -> "Bình thường";
      case 1 -> "Sóng ST-T bất thường";
      case 2 -> "Phì đại tâm thất trái";
      default -> null;
    };
    this.thalach = healthIndicators.getThalach();
    this.exang = healthIndicators.getExang();
    this.exangName = switch (healthIndicators.getExang().intValue()) {
      case 0 -> "Không";
      case 1 -> "Có";
      default -> null;
    };
    this.oldpeak = healthIndicators.getOldpeak();
    this.slope = healthIndicators.getSlope();
    this.ca = healthIndicators.getCa();
    this.thal = healthIndicators.getThal();
    this.target = healthIndicators.getTarget();
    this.targetName = switch (healthIndicators.getTarget() == null ? 3
        : healthIndicators.getTarget().intValue()) {
      case 0 -> "Không";
      case 1 -> "Có";
      default -> null;
    };
  }
}
