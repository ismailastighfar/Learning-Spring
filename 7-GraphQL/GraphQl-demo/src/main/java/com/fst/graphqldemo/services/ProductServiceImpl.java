package com.fst.graphqldemo.services;

import com.fst.graphqldemo.dto.ProductRequestDTO;
import com.fst.graphqldemo.entities.Category;
import com.fst.graphqldemo.entities.Product;
import com.fst.graphqldemo.repositories.CategoryRepository;
import com.fst.graphqldemo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id).orElseThrow(
                ()->new RuntimeException(String.format("Product %s not found ",id))
        );
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Category %s not found",id)));
    }

    @Override
    public Product saveProduct(ProductRequestDTO product) {
        Category category=categoryRepository.findById(product.categoryId()).orElse(null);
        Product productToSave=new Product();
        productToSave.setId(UUID.randomUUID().toString());
        productToSave.setName(product.name());
        productToSave.setPrice(product.price());
        productToSave.setQuantity(product.quantity());
        productToSave.setCategory(category);
        return productRepository.save(productToSave);
    }

    @Override
    public Product updateProduct(String id, ProductRequestDTO product) {
        Product productToSave= getProductById(id);
        productToSave.setName(product.name());
        productToSave.setPrice(product.price());
        productToSave.setQuantity(product.quantity());
        Category category=categoryRepository.findById(product.categoryId()).orElse(null);
        productToSave.setCategory(category);
        return productRepository.save(productToSave);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
