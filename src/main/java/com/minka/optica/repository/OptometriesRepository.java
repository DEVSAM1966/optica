package com.minka.optica.repository;

import com.minka.optica.entities.Optometries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptometriesRepository extends JpaRepository<Optometries, Long> {

}
