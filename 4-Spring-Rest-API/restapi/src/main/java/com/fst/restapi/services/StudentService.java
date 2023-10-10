package com.fst.restapi.services;

import com.fst.restapi.entities.Student;
import com.fst.restapi.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    StudentRepository studentRepository;


    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }


    public Student getStudent( long id){
        return studentRepository.findById(id).orElse(null);
    }


    public Student addStudent(Student student){
        return studentRepository.save(student);
    }


    public void deleteStudent( long id){
        studentRepository.deleteById(id);
    }


    public Student updateStudent( Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(int page,int size,String field){
        Pageable pageable = PageRequest.of(page,size, Sort.by(field));
        Page<Student> studentsPage = studentRepository.findAll(pageable);
        return studentsPage.getContent();
    }
}
