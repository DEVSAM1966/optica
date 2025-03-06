package com.minka.optica.repository;

import com.minka.optica.entities.Optometries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptometriesRepository extends JpaRepository<Optometries, Long> {

    // Busquedas por el campo Optometrist.
    @Query("SELECT e FROM Optometries e WHERE e.optometrist LIKE :valor")
    List<Optometries> findByOptometrist(@Param("valor") String valor);

    // Busquedas por el campo DischargeDate.
    @Query("SELECT e FROM Optometries e WHERE e.dischargeDate LIKE :valor")
    List<Optometries> findByDischargeDate(@Param("valor") String valor);
}
