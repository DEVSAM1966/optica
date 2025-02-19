package com.minka.optica.services.patients;

import com.minka.optica.dataholders.PatientsDh;
import com.minka.optica.dto.PatientsDto;
import java.util.List;

public interface PatientsService {

  PatientsDto save(PatientsDh patientsDh);

  PatientsDto findById(Long id);

  List<PatientsDto> findAll();

  PatientsDto updateById(Long id, PatientsDh patientsDh);

  Boolean deleteById(Long id);

}
