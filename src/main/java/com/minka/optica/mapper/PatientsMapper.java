package com.minka.optica.mapper;

import com.minka.optica.dataholders.PatientsDh;
import com.minka.optica.dto.PatientsDto;
import com.minka.optica.entities.Patients;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientsMapper {

  Patients asEntity(PatientsDh patientsDh);

  PatientsDto asDto(Patients patients);

  List<Patients> asEntityList(List<PatientsDh> patientsDhList);

  List<PatientsDto> asDtoList(List<Patients> patientsList);

}
