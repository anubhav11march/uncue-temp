package com.uncue_core.uncue.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "services")
public class Service {

    @Id
    private String id;
    private String uid;
    private String name;
    private float price;
    private float timeTaken;

}
