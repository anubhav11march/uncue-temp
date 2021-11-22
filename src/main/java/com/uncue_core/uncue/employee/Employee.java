package com.uncue_core.uncue.employee;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int employeeid;
    private int saloonid;
    private String name;
    private String Dob;
    private String Gender;
    private long contactno;
    float rating;
    @ElementCollection
    private List<String> specialty;
    @NotNull
    private String email;
    private Boolean canLogin;
    private String password;
    private String createdBy;
    // private List<String> specialities = new ArrayList();

}
