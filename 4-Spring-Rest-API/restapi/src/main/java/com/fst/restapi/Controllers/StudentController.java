package com.fst.restapi.Controllers;

import com.fst.restapi.entities.Student;
import com.fst.restapi.repositories.StudentRepository;
import com.fst.restapi.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {

    StudentService studentService;

    @GetMapping("student")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("student/{page}/{size}/{field}")
    public List<Student> getAllStudents(
            @PathVariable int page,
            @PathVariable int size,
            @PathVariable String field
    ){
        return studentService.getAllStudents(page, size, field);
    }

    @GetMapping("student/{id}")
    public Student getStudent(@PathVariable long id){
        return studentService.getStudent(id);
    }

    @PostMapping("student")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @DeleteMapping("student/{id}")
    public void deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
    }

    @PutMapping ("student")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }


}
