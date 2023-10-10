package com.fst.restapi.repositories;

import com.fst.restapi.entities.Groupe;
import com.fst.restapi.entities.Student;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
   List<Student> findByGroupe(Groupe groupe);
}
