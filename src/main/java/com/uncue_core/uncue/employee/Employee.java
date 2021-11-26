package com.uncue_core.uncue.employee;

import com.uncue_core.uncue.LobArray.StringArray;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.mapping.Array;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int employeeid;
    @Column(nullable = false)
    private int saloonid;
    private String name;
    private String Dob;
    private String Gender;
    @Column(unique = true)
    private long contactno;
    float rating;
    @Lob
    private StringArray specialty;
    @Column(unique = true,nullable=false)
    private String email;
    private Boolean canLogin;
    private String password;
    private String createdBy;


}
