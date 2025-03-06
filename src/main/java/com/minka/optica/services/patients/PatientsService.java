package com.minka.optica.services.patients;

import com.minka.optica.dataholders.PatientsDh;
import com.minka.optica.dto.PatientsDto;
import com.minka.optica.entities.Patients;

import java.util.List;

public interface PatientsService {

  PatientsDto save(PatientsDh patientsDh);

  PatientsDto findById(Long id);

  List<PatientsDto> findAll();

  List<PatientsDto> findByDni(String valor);

  List<PatientsDto> findByName(String valor);

  List<PatientsDto> findByPhone(String valor);

  List<PatientsDto> findByEmail(String valor);

  List<PatientsDto> findByDischargeDate(String valor);

  PatientsDto updateById(Long id, PatientsDh patientsDh);

  Boolean deleteById(Long id);

}
