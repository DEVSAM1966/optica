package com.minka.optica.entities;

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

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "optometrist", length = 80)
    private String optometrist;

    @Column(name = "symptons", length = 500)
    private String symptons;

    @Column(name = "av_od_sc")
    private Double acOdSc;

    @Column(name = "od_eje")
    private int odEje;

    @Column(name = "od_cilindro")
    private Double odCilindro;

    @Column(name = "od_esfera")
    private Double odEsfera;

    @Column(name = "od_add")
    private Double odAdd;

    @Column(name = "av_od_cc")
    private Double avOdCc;

    @Column(name = "av_oi_sc")
    private Double acOiSc;

    @Column(name = "oi_eje")
    private int oiEje;

    @Column(name = "oi_cilindro")
    private Double oiCilindro;

    @Column(name = "oi_esfera")
    private Double oiEsfera;

    @Column(name = "oi_add")
    private Double oiAdd;

    @Column(name = "av_oi_cc")
    private Double avOiCc;

    @Column(name = "dnp")
    private Double dnp;

    @Column(name = "queratometria_pincipal_od")
    private String queratometriaPrincioalOd;

    @Column(name = "queratometria_secundario_od")
    private String queratometriaSecundarioOd;

    @Column(name = "queratometria_pincipal_oi")
    private String queratometriaPrincioalOi;

    @Column(name = "queratometria_secundario_oi")
    private String queratometriaSecundarioOi;

    @Column(name = "examen_externo")
    private String examenExterno;

    @Column(name = "examen_interno")
    private String examenInterno;

    @Column(name = "comentarios")
    private String comentarios;

}
