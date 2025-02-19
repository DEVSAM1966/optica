package com.minka.optica.repository;

import com.minka.optica.entities.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepository extends JpaRepository<Patients, Long> {

}
