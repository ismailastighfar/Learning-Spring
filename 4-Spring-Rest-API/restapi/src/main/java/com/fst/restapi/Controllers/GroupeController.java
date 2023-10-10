package com.fst.restapi.Controllers;

import com.fst.restapi.entities.Groupe;
import com.fst.restapi.entities.Student;
import com.fst.restapi.repositories.GroupeRespository;
import com.fst.restapi.repositories.StudentRepository;
import com.fst.restapi.services.GroupeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class GroupeController {

   GroupeService groupeService;

    @GetMapping("groupe/{id}")
    public Groupe getGroupe(@PathVariable Long id){
        return  groupeService.getGroupe(id);
    }

    @GetMapping("groupe")
    public List<Groupe> getAllGroupes(){
        return  groupeService.getAllGroupes();
    }

    @PostMapping("groupe")
    public Groupe addGroupe(@RequestBody Groupe groupe){
        return  groupeService.addGroupe(groupe);
    }

    @GetMapping("groupe/{id}/student")
    public List<Student> getStudentsByGroupe(@PathVariable long id){
      return  groupeService.getStudentsByGroupe(id);
    }

    @PostMapping("groupe/{id}/student")
    public Student addStudentToGroupe(@RequestBody Student student,@PathVariable Long id){
       return  groupeService.addStudentToGroupe(student,id);
    }

    @DeleteMapping("groupe/{id}")
    public void deleteGroupe(@PathVariable long id){
        groupeService.deleteGroupe(id);
    }



}
