package com.minka.optica.repository;

import com.minka.optica.entities.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientsRepository extends JpaRepository<Patients, Long> {

    // Busquedas por el campo DNI.
    @Query("SELECT e FROM Patients e WHERE e.dni LIKE :valor")
    List<Patients> findByDni(@Param("valor") String valor);

    // Busquedas por el campo Nombre.
    @Query("SELECT e FROM Patients e WHERE e.name LIKE :valor")
    List<Patients> findByName(@Param("valor") String valor);

    // Busquedas por el campo Phone.
    @Query("SELECT e FROM Patients e WHERE e.phone LIKE :valor")
    List<Patients> findByPhone(@Param("valor") String valor);

    // Busquedas por el campo Email.
    @Query("SELECT e FROM Patients e WHERE e.email LIKE :valor")
    List<Patients> findByEmail(@Param("valor") String valor);

    // Busquedas por el campo DischargeDate.
    @Query("SELECT e FROM Patients e WHERE e.dischargeDate LIKE :valor")
    List<Patients> findByDischargeDate(@Param("valor") String valor);

}
