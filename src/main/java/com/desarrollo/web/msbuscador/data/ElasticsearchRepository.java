package com.desarrollo.web.msbuscador.data;

import com.desarrollo.web.msbuscador.model.pojo.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ElasticsearchRepository {


    private final String [] nameSearchFields = {"name.search", "name.search._2gram", "name.search._3gram"};
    private final String [] descriptionSearchFields = {"description.search", "description.search._2gram", "description.search._3gram"};

    private final ProductRepository productRepository;

    //private final ElasticsearchOperations elasticClient;

    public Product getById(String id){
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

}
