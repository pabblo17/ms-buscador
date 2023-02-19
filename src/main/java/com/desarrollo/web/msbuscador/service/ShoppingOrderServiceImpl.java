package com.desarrollo.web.msbuscador.service;

import com.desarrollo.web.msbuscador.data.ElasticsearchRepository;
import com.desarrollo.web.msbuscador.model.pojo.ProductOrder;
import com.desarrollo.web.msbuscador.model.pojo.ShoppingOrder;
import com.desarrollo.web.msbuscador.model.request.CreateProductOrder;
import com.desarrollo.web.msbuscador.model.request.CreateShoppingOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShoppingOrderServiceImpl implements ShoppingOrderService {

    private final ElasticsearchRepository repository;
    @Override
    public ShoppingOrder createShoppingOrder(CreateShoppingOrder request) {
        if (
                request != null
                        && StringUtils.hasLength(request.getId().trim())
                        && StringUtils.hasLength(request.getClient().trim())
                        && StringUtils.hasLength(request.getDate().trim())
                        && request.getTotal() >= 0
                        && !request.getProducts().isEmpty()
        ){
            UUID uuid = UUID.randomUUID();

            List<ProductOrder> products = new ArrayList<ProductOrder>(){};

            for (CreateProductOrder productOrder: request.getProducts()) {
                products.add(
                        new ProductOrder(
                                productOrder.getId(),
                                productOrder.getName(),
                                productOrder.getQuantity(),
                                productOrder.getPrice()
                        )
                );
            }

            ShoppingOrder shoppingOrder = ShoppingOrder.builder()
                    .id(uuid.toString())
                    .client(request.getClient())
                    .date(request.getDate())
                    .total(request.getTotal())
                    .products(products)
                    .build();
            return repository.saveShoppingOrder(shoppingOrder);
        }else{
            return null;
        }
    }

    @Override
    public List<ShoppingOrder> findShoppingOrderByClient(String clientId) {
        return null;
    }
}
