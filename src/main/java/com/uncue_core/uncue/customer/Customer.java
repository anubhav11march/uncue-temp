package com.uncue_core.uncue.customer;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.Array;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int customerid;
    private int saloonid;
    private String name;
    private String gender;
    private long contactno;
    private boolean isMember;
    @ElementCollection
    private List<String> purchasedPackages;
    private String createdBy;
    private String mailid;

}
