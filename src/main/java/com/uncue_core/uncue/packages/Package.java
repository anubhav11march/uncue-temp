package com.uncue_core.uncue.packages;

import com.uncue_core.uncue.LobArray.StringArray;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
@Entity
@Setter
@Getter
public class Package implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int packageId;
    @Column(nullable = false)
    private String packageName;
    @Column(nullable = false)
    private Float price;
    private long validity;
    @Lob
    private StringArray services;


}

