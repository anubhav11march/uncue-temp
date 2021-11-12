package com.uncue_core.uncue.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "products")
public class Product {

    @Id
    private String productId;
    private String saloonId;
    private String name;
    private String product_code;
    private Date mfg;
    private Date expiryDate;
    private float buyingPrice;
    private float sellingPrice;
    private int Qty;

}
