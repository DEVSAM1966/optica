package com.minka.optica.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "optometries")
public class Optometries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_optometry", length = 10)
    private Long idOptometry;

    @Column(name = "discharge_date", length = 10)
    private String dischargeDate;

    @Column(name = "optometrist", length = 80)
    private String optometrist;

    @Column(name = "symptons")
    private String symptons;

    @Column(name = "va_re_nc", length = 5)
    private String vaReNc;

    @Column(name = "re_axis")
    private int reAxis;

    @Column(name = "re_cylinder", length = 6)
    private String reCylinder;

    @Column(name = "re_sphere", length = 6)
    private String reSphere;

    @Column(name = "re_add", length = 5)
    private String reAdd;

    @Column(name = "va_re_wc", length = 5)
    private String vaReWc;

    @Column(name = "va_le_nc", length = 5)
    private String vaLeSc;

    @Column(name = "le_axis")
    private int leAxis;

    @Column(name = "le_cylinder", length = 6)
    private String leCylinder;

    @Column(name = "le_sphere", length = 6)
    private String leSphere;

    @Column(name = "le_add", length = 5)
    private String leAdd;

    @Column(name = "va_le_wc", length = 5)
    private String vaLeWc;

    @Column(name = "dnp", length = 11)
    private String dnp;

    @Column(name = "main_keratometry_re", length = 14)
    private String mainKeratometryRe;

    @Column(name = "secondary_keratometry_re", length = 14)
    private String secondaryKeratometryRe;

    @Column(name = "main_keratometry_le", length = 14)
    private String mainKeratometryLe;

    @Column(name = "secondary_keratometry_le", length = 14)
    private String secondaryKeratometryLe;

    @Column(name = "external_examination")
    private String externalExamination;

    @Column(name = "internal_examination")
    private String internalExamination;

    @Column(name = "feedback")
    private String feedback;

    @ManyToOne
    @JoinColumn(name = "idPatient", referencedColumnName = "id_patient")
    @JsonIgnore
    private Patients patients;

}
