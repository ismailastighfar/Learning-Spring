package com.fst.graphqldemo.repositories;

import com.fst.graphqldemo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
