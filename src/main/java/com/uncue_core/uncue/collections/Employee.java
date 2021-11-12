package com.uncue_core.uncue.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "employees")
public class Employee {

    @Id
    private String employeeId;
    private String saloonId;
    private String name;
    private String dob;
    private String gender;
    private String contact;
    private int rating;
    private List<String> specialities = new ArrayList();

}
