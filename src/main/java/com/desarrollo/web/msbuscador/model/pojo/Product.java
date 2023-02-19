package com.desarrollo.web.msbuscador.model.pojo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

@Document(indexName = "products", createIndex = false)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    private String id;

    @MultiField(mainField = @Field(type = FieldType.Keyword, name = "name"),
    otherFields = @InnerField(suffix = "search", type = FieldType.Search_As_You_Type)
    )
    private String name;

    @Field(type = FieldType.Keyword, name = "urlImg")
    private String urlImg;

    @Field(type = FieldType.Float, name = "country")
    private Float price;

    @Field(type = FieldType.Integer, name = "stock")
    private Integer stock;

    @MultiField(mainField = @Field(type = FieldType.Keyword, name = "description"),
            otherFields = @InnerField(suffix = "search", type = FieldType.Search_As_You_Type)
    )
    private String description;

    @MultiField(mainField = @Field(type = FieldType.Keyword, name = "category"),
            otherFields = @InnerField(suffix = "search", type = FieldType.Search_As_You_Type)
    )
    private String category;

    @MultiField(mainField = @Field(type = FieldType.Keyword, name = "brand"),
            otherFields = @InnerField(suffix = "search", type = FieldType.Search_As_You_Type)
    )
    private String brand;
}
