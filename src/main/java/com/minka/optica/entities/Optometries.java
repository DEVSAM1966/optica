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

    @Column(name = "fecha", length = 10)
    private String fecha;

    @Column(name = "optometrist", length = 80)
    private String optometrist;

    @Column(name = "symptons", length = 255)
    private String symptons;

    @Column(name = "av_od_sc", length = 5)
    private String avOdSc;

    @Column(name = "od_eje")
    private int odEje;

    @Column(name = "od_cilindro", length = 6)
    private String odCilindro;

    @Column(name = "od_esfera", length = 6)
    private String odEsfera;

    @Column(name = "od_add", length = 5)
    private String odAdd;

    @Column(name = "av_od_cc", length = 5)
    private String avOdCc;

    @Column(name = "av_oi_sc", length = 5)
    private String avOiSc;

    @Column(name = "oi_eje")
    private int oiEje;

    @Column(name = "oi_cilindro", length = 6)
    private String oiCilindro;

    @Column(name = "oi_esfera", length = 6)
    private String oiEsfera;

    @Column(name = "oi_add", length = 5)
    private String oiAdd;

    @Column(name = "av_oi_cc", length = 5)
    private String avOiCc;

    @Column(name = "dnp", length = 5)
    private String dnp;

    @Column(name = "main_keratometry_od", length = 14)
    private String mainKeratometryOd;

    @Column(name = "secondary_keratometry_od", length = 14)
    private String secondaryKeratometryOd;

    @Column(name = "main_keratometry_oi", length = 14)
    private String mainKeratometryOi;

    @Column(name = "secondary_keratometry_oi", length = 14)
    private String secondaryKeratometryOi;

    @Column(name = "external_examination", length = 255)
    private String externalExamination;

    @Column(name = "internal_examination", length = 255)
    private String internalExamination;

    @Column(name = "feedback", length = 255)
    private String feedback;

    @ManyToOne
    @JoinColumn(name = "idPatient", referencedColumnName = "id_patient")
    @JsonIgnore
    private Patients patients;

}
