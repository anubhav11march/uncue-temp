package com.uncue_core.uncue.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class IUDReturningMessage {

    public IUDReturningMessage() {

    }

    private String message;
    private String details;
    private boolean error;

}
