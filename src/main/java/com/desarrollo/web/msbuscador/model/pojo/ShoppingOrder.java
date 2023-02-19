package com.desarrollo.web.msbuscador.model.pojo;

import com.desarrollo.web.msbuscador.model.request.CreateProductOrder;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.util.Date;
import java.util.List;

@Document(indexName = "shopping-orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShoppingOrder {

    @Id
    private String id;

    @Field(type = FieldType.Keyword, name = "client")
    private String client;

    @Field(type = FieldType.Text, name = "date")
    private String date;

    @Field(type = FieldType.Float, name = "total")
    private Float total;

    @Field(type = FieldType.Nested, name = "products")
    private List<ProductOrder> products;


}
