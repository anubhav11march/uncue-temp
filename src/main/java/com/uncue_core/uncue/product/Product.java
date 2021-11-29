package com.uncue_core.uncue.product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int productId;
    @Column(nullable = false)
    private int saloonId;
    private String name;
    private String expiryDate;
    private float sellingPrice;
    private int qty;

}
