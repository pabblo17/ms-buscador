package com.desarrollo.web.msbuscador.controller;

import com.desarrollo.web.msbuscador.data.ElasticsearchRepository;
import com.desarrollo.web.msbuscador.model.pojo.Product;
import com.desarrollo.web.msbuscador.model.request.CreateProductRequest;
import com.desarrollo.web.msbuscador.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping(path = "/test")
    public String getTest(){
        return "";
    }

    @GetMapping(path = "/products")
    public String getProducts(){
        return "";
    }


    @PostMapping(path = "/products")
    public ResponseEntity<Product> saveProducts(@RequestBody CreateProductRequest request){
        Product createProduct = service.createProduct(request);
        if (createProduct!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createProduct);
        }else {
            return ResponseEntity.badRequest().build();
        }

    }
}
