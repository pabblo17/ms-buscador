package com.desarrollo.web.msbuscador.controller;

import com.desarrollo.web.msbuscador.model.pojo.ShoppingOrder;;
import com.desarrollo.web.msbuscador.model.request.CreateShoppingOrder;
import com.desarrollo.web.msbuscador.service.ShoppingOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ShoppingOrderController {

    private final ShoppingOrderService service;

    @GetMapping(path = "/orders/{client-id}")
    public ResponseEntity<ShoppingOrder> saveShoppingOrder(@PathVariable(name = "client-id") String clientId){
        /*ShoppingOrder shoppingOrder = service.(request);
        if (shoppingOrder!=null){

            return ResponseEntity.status(HttpStatus.CREATED).body(shoppingOrder);
        }else {
            return ResponseEntity.badRequest().build();
        }*/
        return ResponseEntity.badRequest().build();
    }

    @PostMapping(path = "/orders")
    public ResponseEntity<ShoppingOrder> saveShoppingOrder(@RequestBody CreateShoppingOrder request){
        ShoppingOrder shoppingOrder = service.createShoppingOrder(request);
        if (shoppingOrder!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(shoppingOrder);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
}
