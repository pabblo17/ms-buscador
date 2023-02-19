package com.desarrollo.web.msbuscador.data;

import com.desarrollo.web.msbuscador.model.pojo.Product;
import com.desarrollo.web.msbuscador.model.pojo.ShoppingOrder;
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
    private final ShoppingOrderRepository shoppingOrderRepositoryRepository;

    //private final ElasticsearchOperations elasticClient;


    // PRODUCTS
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public Product getById(String id){
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }


    // SHOPPING ORDERS

    public ShoppingOrder saveShoppingOrder(ShoppingOrder shoppingOrder){
        return shoppingOrderRepositoryRepository.save(shoppingOrder);
    }
}
