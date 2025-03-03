package com.minka.optica.services.patients;

import com.minka.optica.dataholders.PatientsDh;
import com.minka.optica.dto.PatientsDto;
import com.minka.optica.entities.Patients;
import com.minka.optica.exceptions.BdNotFoundException;
import com.minka.optica.exceptions.BdNotSaveException;
import com.minka.optica.mapper.PatientsMapper;
import com.minka.optica.repository.PatientsRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class PatientsServiceImp implements PatientsService{

  @NonNull
  private final PatientsRepository patientsRepository;

  @NonNull
  private final PatientsMapper patientsMapper;

  @Override
  public PatientsDto save(final PatientsDh patientsDh) {
    final Patients patients = this.patientsMapper.asEntity(patientsDh);
    final Patients patientsSaved = this.patientsRepository.save(patients);
    final PatientsDto patientsDto = this.patientsMapper.asDto(patientsSaved);
    return patientsDto;
  }

  @Override
  public PatientsDto findById(final Long id) {
    final Optional<Patients> patientsOptional = this.patientsRepository.findById(id);
    if (patientsOptional.isPresent()) {
      final PatientsDto patientsDto = this.patientsMapper.asDto(patientsOptional.get());
      return patientsDto;
    } else {
      throw new BdNotFoundException("GET - There are no patients in the database");
    }
  }

  @Override
  public List<PatientsDto> findAll() {
    final List<Patients> patientsList = (List<Patients>) this.patientsRepository.findAll();
    if (CollectionUtils.isEmpty(patientsList)) {
      log.warn("Findall - There are no patients in the database");
      return Collections.emptyList();
    } else {
      final List<PatientsDto> patientsDtoList = this.patientsMapper.asDtoList(patientsList);
      return patientsDtoList;
    }
  }

  @Override
  public PatientsDto updateById(final Long id, final PatientsDh patientsDh) {
    final Patients patients = this.patientsMapper.asEntity(patientsDh);
    final Optional<Patients> existPatients = this.patientsRepository.findById(id);

    if (patientsDh.getIdPatient() != id) {
        throw new BdNotSaveException("PUT - Parameters are incorrect for field idPatient: " + patientsDh.getIdPatient() + " is different at is: " + id);
    }

    if (existPatients.isPresent()) {
      final Patients patientsSaved = this.patientsRepository.save(patients);
      final PatientsDto patientsDto = this.patientsMapper.asDto(patientsSaved);
      return patientsDto;
    } else {
      throw new BdNotFoundException("PUT - There is no patients in the database with the id: " + id);
    }
  }

  @Override
  public Boolean deleteById(final Long id) {
    final Optional<Patients> existPatients = this.patientsRepository.findById(id);
    if (existPatients.isPresent()) {
      this.patientsRepository.deleteById(id);
      return true;
    } else {
      throw new BdNotFoundException("DELETE - There is no patients in the database with the id: " + id);
    }
  }

}
