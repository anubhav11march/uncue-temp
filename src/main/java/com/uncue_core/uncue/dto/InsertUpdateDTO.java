package com.uncue_core.uncue.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class InsertUpdateDTO {

    public InsertUpdateDTO(){

    }

    private String keyName;

    private String keyValue;

    private String tableName;

    private String status;

    private String columnType;

    private String imageNameDisplay;

}
