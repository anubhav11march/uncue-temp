package com.uncue_core.uncue.customer;

import com.uncue_core.uncue.LobArray.StringArray;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.Array;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Setter
@Getter
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int customerid;
    @Column(nullable = false)
    private int saloonid;
    private String name;
    private String gender;
    private long contactno;
    private boolean isMember;
    @Lob
    private StringArray purchasedPackages;
    private String createdBy;
    @Column(unique = true,nullable=false)
    private String mailid;

}
