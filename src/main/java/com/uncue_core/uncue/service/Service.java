package com.uncue_core.uncue.service;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "service")
public class Service implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "serviceId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceId;

    @Column(name = "Name",nullable = false)
    private String name;

    @Column(name = "Price")
    private Float price;

    @Column(name = "bodyPart")
    private String bodyPart;

    @Column(name = "duration")
    private Float duration;

    @Column(name = "saloonId", nullable = false)
    private Integer saloonId;

}
