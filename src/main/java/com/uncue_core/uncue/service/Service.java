package com.uncue_core.uncue.service;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Service {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int serviceId;
    int saloonId;
    String Name;
    Float Price;
    Float duration;
    String bodyPart;


}
