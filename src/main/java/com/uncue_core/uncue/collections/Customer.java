package com.uncue_core.uncue.collections;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customers")
@NoArgsConstructor
public class Customer {

    @Id
    private String id;
    private String name;
    private String dob;
    private String gender;
    private String contact;
}
