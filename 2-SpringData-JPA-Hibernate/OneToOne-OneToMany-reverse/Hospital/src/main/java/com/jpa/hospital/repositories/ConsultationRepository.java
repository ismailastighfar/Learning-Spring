package com.jpa.hospital.repositories;

import com.jpa.hospital.entities.Consultation;
import com.jpa.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
