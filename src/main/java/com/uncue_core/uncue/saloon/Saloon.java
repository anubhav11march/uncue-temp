package com.uncue_core.uncue.saloon;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Setter
@Getter
public class Saloon implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int saloonId;
    private String name;
    private String email;
    private long phoneNumber;
    private String password;
    private Byte[] imageURL;
    private Boolean approved;
    private String approvedBy;






}
