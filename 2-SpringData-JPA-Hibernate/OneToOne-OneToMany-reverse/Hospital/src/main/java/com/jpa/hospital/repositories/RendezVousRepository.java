package com.jpa.hospital.repositories;

import com.jpa.hospital.entities.Patient;
import com.jpa.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {
}
