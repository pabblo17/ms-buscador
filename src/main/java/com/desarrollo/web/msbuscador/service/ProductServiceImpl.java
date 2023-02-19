package com.desarrollo.web.msbuscador.service;

import com.desarrollo.web.msbuscador.data.ElasticsearchRepository;
import com.desarrollo.web.msbuscador.model.pojo.Product;
import com.desarrollo.web.msbuscador.model.request.CreateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ElasticsearchRepository repository;

    @Override
    public Product createProduct(CreateProductRequest request) {
        if (
                request != null
                        && StringUtils.hasLength(request.getName().trim())
                        && StringUtils.hasLength(request.getUrlImg().trim())
                        && StringUtils.hasLength(request.getName().trim())
                        && request.getPrice() > (float)-1
                        && request.getStock() >= 0
                        && StringUtils.hasLength(request.getDescription().trim())
                        && StringUtils.hasLength(request.getCategory().trim())
                        && StringUtils.hasLength(request.getBrand().trim())
        ){
            Product product = Product.builder()
                    .id(String.valueOf(request.getName().hashCode()))
                    .name(request.getName())
                    .urlImg(request.getUrlImg())
                    .price(request.getPrice())
                    .stock(request.getStock())
                    .description(request.getDescription())
                    .category(request.getCategory())
                    .brand(request.getBrand())
                    .build();
            return repository.saveProduct(product);
        }else{
            return null;
        }

    }
}
