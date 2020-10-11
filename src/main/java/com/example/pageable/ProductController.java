package com.example.pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

//    Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
//    Pageable secondPageWithFiveElements = PageRequest.of(1, 5);

//    Page<Product> allProducts = productRepository.findAll(firstPageWithTwoElements);
//    List<Product> allTenDollarProducts = productRepository.findAllByPrice(10, secondPageWithFiveElements);

    @GetMapping
    public Page<Product> getPageSize(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
//        Page <Product> allProducts = productRepository.findAll(pageable);
        return productRepository.findAll(pageable);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

}
