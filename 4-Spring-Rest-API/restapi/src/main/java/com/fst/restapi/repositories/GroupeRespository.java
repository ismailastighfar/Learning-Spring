package com.fst.restapi.repositories;

import com.fst.restapi.entities.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupeRespository extends JpaRepository<Groupe,Long> {
}
