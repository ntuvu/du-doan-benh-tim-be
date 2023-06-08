package com.example.data_mining.services;

import com.example.data_mining.commons.Constant;
import com.example.data_mining.dtos.ForecastRequest;
import com.example.data_mining.dtos.PatientDetailDTO;
import com.example.data_mining.dtos.PatientListDTO;
import com.example.data_mining.repositories.PatientRepository;
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
  private final RestTemplate restTemplate;

  public Page<PatientListDTO> getPatientList(Pageable pageable) {
    return patientRepository.getPatientList(pageable);
  }

  public PatientDetailDTO getPatientById(int id) {
    return patientRepository.getPatientById(id);
  }

  public String forecast(ForecastRequest request) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<ForecastRequest> requestEntity = new HttpEntity<>(request, headers);
    ResponseEntity<String> response = restTemplate.exchange(Constant.knn, HttpMethod.POST, requestEntity, String.class);
    String result = response.getBody();
    assert result != null;
    if (result.equals(Constant.YES)) {
      return "Bệnh nhân có nguy cơ bị bệnh tim";
    }
    return "Bệnh nhân không có nguy cơ bị tim";
  }
}
