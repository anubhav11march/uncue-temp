package com.uncue_core.uncue.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ReturningMessage {
    public ReturningMessage() {
    }
    private String statusMessage;
    private String data;
    private boolean error;

}
