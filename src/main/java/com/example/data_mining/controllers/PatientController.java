package com.example.data_mining.controllers;

import com.example.data_mining.dtos.CreatePatientRequest;
import com.example.data_mining.dtos.ForecastRequest;
import com.example.data_mining.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PatientController {

  private final PatientService patientService;

  @GetMapping
  public ResponseEntity<Object> getPatientList(Pageable pageable) {
    return new ResponseEntity<>(patientService.getPatientList(pageable), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getPatientById(@PathVariable int id) {
    return new ResponseEntity<>(patientService.getPatientById(id), HttpStatus.OK);
  }

  @PostMapping("/forecast")
  public ResponseEntity<Object> forecastPatient(@RequestBody ForecastRequest request) {
    return new ResponseEntity<>(patientService.forecast(request), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Object> createPatient(@RequestBody CreatePatientRequest request) {
    patientService.createPatient(request);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}
