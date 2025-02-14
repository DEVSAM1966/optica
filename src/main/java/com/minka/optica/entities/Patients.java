package com.minka.optica.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "patients")
public class Patients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_patient", length = 5)
    private Long idPatient;

    @Column(name = "name_patient", length = 70)
    private String namePatient;

    @Column(name = "dni_patient", length = 14, unique = true)
    private String dniPatient;

    @Column(name = "adress_patient", length = 80)
    private String adressPatient;

    @Column(name = "locality_patient", length = 80)
    String localityPatient;

    @Column(name = "province_patient", length = 40)
    private String provincePatient;

    @Column(name = "zip_code_patient", length = 11)
    private String zipCodePatient;

    @Column(name = "phone_patient", length = 16)
    private String phonePatient;

    @Column(name = "email_patient", length = 100)
    private String emailPatient;

    @Column(name = "profession_patient", length = 35)
    private String professionPatient;

    @Column(name = "discharge_date_patient", length = 10)
    private String dischargeDatePatient;

    @Column(name = "notes_patient")
    private String notesPatient;

}
