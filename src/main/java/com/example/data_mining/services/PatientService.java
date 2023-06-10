package com.example.data_mining.services;

import com.example.data_mining.commons.Constant;
import com.example.data_mining.dtos.CreatePatientRequest;
import com.example.data_mining.dtos.ForecastRequest;
import com.example.data_mining.dtos.PatientDetailDTO;
import com.example.data_mining.models.HealthIndicators;
import com.example.data_mining.models.Patient;
import com.example.data_mining.repositories.HealthIndicatorsRepository;
import com.example.data_mining.repositories.PatientRepository;
import java.util.Objects;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PatientService {

  private final PatientRepository patientRepository;
  private final HealthIndicatorsRepository healthIndicatorsRepository;
  private final RestTemplate restTemplate;

  public Page<PatientDetailDTO> getPatientList(Pageable pageable) {
    return patientRepository.findPatients(pageable);
  }

  public PatientDetailDTO getPatientById(int id) {
    return patientRepository.getPatientById(id);
  }

  public String forecast(ForecastRequest request) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<ForecastRequest> requestEntity = new HttpEntity<>(request, headers);
    ResponseEntity<String> response = restTemplate.exchange(Constant.knn, HttpMethod.POST,
        requestEntity, String.class);
    if (response.getBody() == null) {
      return "Lỗi xử lý";
    }
    String result = Objects.requireNonNull(response.getBody()).trim().replaceAll("^\"|\"$", "");
    if (result.equals(Constant.YES)) {
      return "Bệnh nhân có nguy cơ bị bệnh tim";
    }
    return "Bệnh nhân không có nguy cơ bị tim";
  }

  public void createPatient(CreatePatientRequest request) {
    HealthIndicators healthIndicators = new HealthIndicators(request);
    Integer healthIndicatorsId = healthIndicatorsRepository.saveAndFlush(healthIndicators).getId();
    Patient patient = new Patient(request, healthIndicatorsId);
    patientRepository.save(patient);
  }

  public void deletePatient(int id) {
    Patient patient = patientRepository.findById(id).orElseThrow();
    int healthIndicatorsId = patient.getHealthIndicatorsId();
    patientRepository.deleteById(id);
    healthIndicatorsRepository.deleteById(healthIndicatorsId);
  }

  public void updatePatient(int id, @NonNull CreatePatientRequest request) {
    Patient patient = patientRepository.findById(id).orElseThrow();
    HealthIndicators healthIndicators = healthIndicatorsRepository.findById(
        patient.getHealthIndicatorsId()).orElseThrow();
    patient.replace(request);
    healthIndicators.replace(request);
    patientRepository.save(patient);
    healthIndicatorsRepository.save(healthIndicators);
  }
}
