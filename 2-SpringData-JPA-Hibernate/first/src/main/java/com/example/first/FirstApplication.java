package com.example.first;

import com.example.first.entities.Patient;
import com.example.first.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class FirstApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(FirstApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i < 50; i++) {
            patientRepository.save(
                    new Patient(null ,"ismail",new Date(), Math.random() > 0.5,(int)(Math.random()*500)));
        }

        // Pagination
        Page<Patient> patients = patientRepository.findAll(PageRequest.of(0,5));
        System.out.println("TOTAL pages" + patients.getTotalPages());
        System.out.println("num elm" + patients.getTotalElements());
        System.out.println("num pages" + patients.getNumber());
        List<Patient> content = patients.getContent();
        //

        // find a patient by is malade
        List<Patient> byMalade = patientRepository.findByMalade(false);
        // find a patient by is malade + pagination
        Page<Patient> PMalade = patientRepository.findByMalade(true,PageRequest.of(0,5));

        PMalade.forEach(p->{
            System.out.println("-----------------------");
            System.out.println(p.getId());
            System.out.println(p.getName());
        });

        System.out.println("-----------------------");

        // find a patient by id
        Patient patient = patientRepository.findById(1L).orElse(null);
        if (patient!=null){
            System.out.println(patient.getName());
        }

        // update
        patient.setScore(90);
        patientRepository.save(patient);
        // delete
        patientRepository.deleteById(1L);



    }
}
