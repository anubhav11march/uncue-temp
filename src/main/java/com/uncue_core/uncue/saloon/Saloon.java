package com.uncue_core.uncue.saloon;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
public class Saloon implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int saloonId;
    @Column(nullable = false)
    private String name;
    @Column(unique = true,nullable=false)
    private String email;
    @Column(unique = true,nullable=false)
    private long phoneNumber;
    private String password;
    private Byte[] imageURL;
    private Boolean approved;
    private String approvedBy;






}
