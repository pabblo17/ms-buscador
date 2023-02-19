package com.desarrollo.web.msbuscador.data;

import com.desarrollo.web.msbuscador.model.pojo.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {

}
