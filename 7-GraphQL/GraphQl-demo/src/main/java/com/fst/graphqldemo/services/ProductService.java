package com.fst.graphqldemo.services;

import com.fst.graphqldemo.dto.ProductRequestDTO;
import com.fst.graphqldemo.entities.Category;
import com.fst.graphqldemo.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(String id);
    List<Category> getAllCategory();
    Category getCategoryById(Long id);
    Product saveProduct(ProductRequestDTO product);
    Product updateProduct(String id,ProductRequestDTO product);
    void deleteProduct(String id);
}
