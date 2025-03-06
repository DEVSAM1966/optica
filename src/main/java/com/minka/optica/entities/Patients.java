package com.minka.optica.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "name", nullable = false, length = 70)
    private String name;

    @Column(name = "dni", nullable = false, length = 14, unique = true)
    private String dni;

    @Column(name = "address", nullable = false, length = 80)
    private String address;

    @Column(name = "locality", nullable = false, length = 80)
    String locality;

    @Column(name = "province", nullable = false, length = 40)
    private String province;

    @Column(name = "zip_code", nullable = false, length = 11)
    private String zipCode;

    @Column(name = "phone", nullable = false, length = 16)
    private String phone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "profession", length = 35)
    private String profession;

    @Column(name = "discharge_date", nullable = false, length = 10)
    private String dischargeDate;

    @Column(name = "notes")
    private String notes;

    @OneToMany(mappedBy = "patients", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = false)
    @JsonIgnore
    private List<Optometries> optometriesList;

}
