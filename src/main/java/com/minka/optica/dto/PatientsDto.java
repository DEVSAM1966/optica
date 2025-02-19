package com.minka.optica.dto;

import com.minka.optica.entities.Optometries;
import java.util.List;
import lombok.Data;

@Data
public class PatientsDto {

  private Long idPatient;

  private String name;

  private String dni;

  private String adress;

  String locality;

  private String province;

  private String zipCode;

  private String phone;

  private String email;

  private String profession;

  private String dischargeDate;

  private String notes;

  private List<Optometries> optometriesList;
}
