package com.example.data_mining.repositories;

import com.example.data_mining.dtos.PatientDetailDTO;
import com.example.data_mining.dtos.PatientListDTO;
import com.example.data_mining.models.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

  @Query(value = """
select new com.example.data_mining.dtos.PatientListDTO(p)
from Patient p
""")
  Page<PatientListDTO> getPatientList(Pageable pageable);

  @Query(value = """
select new com.example.data_mining.dtos.PatientDetailDTO(p, h)
from Patient p
join HealthIndicators h on p.healthIndicatorsId = h.id
where p.id = :id
""")
  PatientDetailDTO getPatientById(int id);
}
