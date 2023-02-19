package com.desarrollo.web.msbuscador.data;

import com.desarrollo.web.msbuscador.model.pojo.ShoppingOrder;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ShoppingOrderRepository extends ElasticsearchRepository<ShoppingOrder, String> {


}
