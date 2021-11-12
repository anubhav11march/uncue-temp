package com.uncue_core.uncue.collections;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customers")
public class Customer {

    @Id
    private String customerId;
    private String saloonId;
    private String name;
    private String dob;
    private String gender;
    private String contact;

}
