package com.minka.optica.dataholders;

import com.minka.optica.entities.Patients;
import lombok.Data;

@Data
public class OptometriesDh {

  private Long idOptometry;

  private String dischargeDate;

  private String optometrist;

  private String symptons;

  private String vaReNc;

  private int reAxis;

  private String reCylinder;

  private String reSphere;

  private String reAdd;

  private String vaReWc;

  private String vaLeSc;

  private int leAxis;

  private String leCylinder;

  private String leSphere;

  private String leAdd;

  private String vaLeWc;

  private String dnp;

  private String mainKeratometryRe;

  private String secondaryKeratometryRe;

  private String mainKeratometryLe;

  private String secondaryKeratometryLe;

  private String externalExamination;

  private String internalExamination;

  private String feedback;

  private Patients patients;

}
