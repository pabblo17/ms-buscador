package com.desarrollo.web.msbuscador.model.request;

import com.desarrollo.web.msbuscador.model.pojo.Product;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateShoppingOrder {

    private String id;
    private String client;
    private String date;
    private Float total;
    private List<CreateProductOrder> products;

}