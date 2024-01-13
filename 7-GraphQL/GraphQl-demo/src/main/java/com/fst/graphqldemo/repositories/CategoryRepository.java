package com.fst.graphqldemo.repositories;

import com.fst.graphqldemo.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
