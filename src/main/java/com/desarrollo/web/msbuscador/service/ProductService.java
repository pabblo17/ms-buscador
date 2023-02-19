package com.desarrollo.web.msbuscador.service;

import com.desarrollo.web.msbuscador.model.pojo.Product;
import com.desarrollo.web.msbuscador.model.request.CreateProductRequest;

public interface ProductService {

    Product createProduct(CreateProductRequest request);

}
