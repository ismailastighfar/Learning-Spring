package com.fst.restapi.services;

import com.fst.restapi.entities.Groupe;
import com.fst.restapi.entities.Student;
import com.fst.restapi.repositories.GroupeRespository;
import com.fst.restapi.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupeService {

    GroupeRespository groupeRespository;
    StudentRepository studentRepository;


    public Groupe getGroupe( Long id){
        return groupeRespository.findById(id).orElse(null);
    }


    public List<Groupe> getAllGroupes(){
        return groupeRespository.findAll();
    }


    public Groupe addGroupe(Groupe groupe){
        return groupeRespository.save(groupe);
    }


    public List<Student> getStudentsByGroupe(long id){
        Groupe groupe = groupeRespository.findById(id).get();
        return studentRepository.findByGroupe(groupe);
    }


    public Student addStudentToGroupe(Student student,Long id){
        Groupe groupe = groupeRespository.findById(id).get();
        student.setGroupe(groupe);
        return studentRepository.save(student);
    }

    public void deleteGroupe(long id) {
        List<Student> students = getStudentsByGroupe(id);
        students.forEach(s->{
            s.setGroupe(null);
        });
        groupeRespository.deleteById(id);
    }
}
