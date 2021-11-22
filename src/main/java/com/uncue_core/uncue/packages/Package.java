package com.uncue_core.uncue.packages;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
@Entity
@Setter
@Getter
public class Package {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int packageId;
    private String packageName;
    private Float price;
    private long validity;
    private ArrayList<Integer> services;


}

