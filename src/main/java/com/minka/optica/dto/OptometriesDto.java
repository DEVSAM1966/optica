package com.minka.optica.dto;

import com.minka.optica.entities.Patients;
import lombok.Data;

@Data
public class OptometriesDto {

  private Long idOptometry;

  private String fecha;

  private String optometrist;

  private String symptons;

  private String avOdSc;

  private int odEje;

  private String odCilindro;

  private String odEsfera;

  private String odAdd;

  private String avOdCc;

  private String avOiSc;

  private int oiEje;

  private String oiCilindro;

  private String oiEsfera;

  private String oiAdd;

  private String avOiCc;

  private String dnp;

  private String mainKeratometryOd;

  private String secondaryKeratometryOd;

  private String mainKeratometryOi;

  private String secondaryKeratometryOi;

  private String externalExamination;

  private String internalExamination;

  private String feedback;

  private Patients patients;

}
