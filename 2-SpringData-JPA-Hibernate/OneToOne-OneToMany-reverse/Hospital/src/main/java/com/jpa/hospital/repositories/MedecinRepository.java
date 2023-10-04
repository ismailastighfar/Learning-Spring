package com.jpa.hospital.repositories;

import com.jpa.hospital.entities.Medecin;
import com.jpa.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
}
