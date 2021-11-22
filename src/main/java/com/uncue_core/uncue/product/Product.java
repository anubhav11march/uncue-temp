package com.uncue_core.uncue.product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int productId;
    private int saloonId;
    private String name;
    private String productCode;
    private float sellingPrice;
    private int qty;

}
