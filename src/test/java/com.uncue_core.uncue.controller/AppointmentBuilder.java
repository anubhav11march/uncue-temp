package com.uncue_core.uncue.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class AppointmentBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static AppointmentDto getDto() {
        AppointmentDto dto = new AppointmentDto();
        dto.setId("1");
        return dto;
    }
}
