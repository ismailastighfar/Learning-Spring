package com.fst.graphqldemo.web;

import com.fst.graphqldemo.dto.ProductRequestDTO;
import com.fst.graphqldemo.entities.Category;
import com.fst.graphqldemo.entities.Product;
import com.fst.graphqldemo.services.ProductService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductGraphQlController {

    private ProductService productService;

    public ProductGraphQlController(ProductService productService) {
        this.productService = productService;
    }

    @QueryMapping
    public List<Product> productList(){
        return productService.getAllProducts();
    }

    @QueryMapping
    public Product productById(@Argument String id){
        return productService.getProductById(id);
    }

    @QueryMapping
    public List<Category> categoryList(){
        return productService.getAllCategory();
    }

    @QueryMapping
    public Category categoryById(@Argument Long id){
        return productService.getCategoryById(id);
    }


    @MutationMapping
    public Product saveProduct(@Argument ProductRequestDTO product){
        return productService.saveProduct(product);
    }

    @MutationMapping
    public Product updateProduct(@Argument String id,@Argument ProductRequestDTO product){
        return productService.updateProduct(id,product);
    }

    @MutationMapping
    public void deleteProduct(@Argument String id){
        productService.deleteProduct(id);
    }
}
