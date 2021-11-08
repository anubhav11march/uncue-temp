package com.uncue_core.uncue.collections;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "employees")
@NoArgsConstructor
public class Employee {

    @Id
    private String id;
    private String name;
    private String dob;
    private String gender;
    private String contact;
}
