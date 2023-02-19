package com.desarrollo.web.msbuscador.service;

import com.desarrollo.web.msbuscador.model.pojo.ShoppingOrder;
import com.desarrollo.web.msbuscador.model.request.CreateShoppingOrder;

import java.util.List;

public interface ShoppingOrderService {

    ShoppingOrder createShoppingOrder(CreateShoppingOrder request);

    List<ShoppingOrder> findShoppingOrderByClient(String clientId);
}
