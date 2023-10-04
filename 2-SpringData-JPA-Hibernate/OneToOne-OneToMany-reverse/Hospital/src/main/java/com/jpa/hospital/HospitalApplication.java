package com.jpa.hospital;

import com.jpa.hospital.entities.*;
import com.jpa.hospital.repositories.ConsultationRepository;
import com.jpa.hospital.repositories.MedecinRepository;
import com.jpa.hospital.repositories.PatientRepository;
import com.jpa.hospital.repositories.RendezVousRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Bean
	CommandLineRunner start(PatientRepository patientRepository,
							MedecinRepository medecinRepository,
							RendezVousRepository rendezVousRepository,
							ConsultationRepository consultationRepository
	){
		return args -> {
			Stream.of("ismail" ,"amal","oumnia")
					.forEach(name->{
						Patient patient = new Patient();
						patient.setDateNaissance(new Date());
						patient.setName(name);
						patient.setMalade(Math.random()>0.5);
						patientRepository.save(patient);
					});
			Stream.of("med" ,"med1","med2")
					.forEach(name->{
						Medecin medecin = new Medecin();
						medecin.setName(name);
						medecin.setEmail(name+"@gmail.com");
						medecin.setSpecialite(Math.random()>0.5?"cardio":"dentist");
						medecinRepository.save(medecin);
					});

			Patient patient = patientRepository.findById(1L).orElse(null);
			Medecin medecin = medecinRepository.findById(2L).orElse(null);
			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setPatient(patient);
			rendezVous.setMedecin(medecin);
			rendezVous.setStatusRDV(StatusRDV.PENDING);
			rendezVousRepository.save(rendezVous);

			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRapport("rapport...");
			RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);
			consultation.setRendezVous(rendezVous1);
			consultationRepository.save(consultation);


		};
	}
}
