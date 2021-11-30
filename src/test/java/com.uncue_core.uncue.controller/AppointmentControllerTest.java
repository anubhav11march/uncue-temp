package com.uncue_core.uncue.controller;

import com.uncue_core.uncue.appointment.AppointmentController;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Transactional
public class AppointmentControllerTest {
    private static final String ENDPOINT_URL = "/api/appointment;@InjectMocks
    private AppointmentController appointmentController;
    @Mock
    private AppointmentService appointmentService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(appointmentController)
                //.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                //.addFilter(CustomFilter::doFilter)
                .build();
    }

    @Test
    public void findAllByPage() throws Exception {
        Page<AppointmentDto> page = new PageImpl<>(Collections.singletonList(AppointmentBuilder.getDto()));

        Mockito.when(appointmentService.findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(page);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.content", Matchers.hasSize(1)));

        Mockito.verify(appointmentService, Mockito.times(1)).findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any());
        Mockito.verifyNoMoreInteractions(appointmentService);

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(appointmentService.findById(ArgumentMatchers.anyInt())).thenReturn(AppointmentBuilder.getDto());

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(appointmentService, Mockito.times(1)).findById("1");
        Mockito.verifyNoMoreInteractions(appointmentService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(appointmentService.save(ArgumentMatchers.any(AppointmentDto.class))).thenReturn(AppointmentBuilder.getDto());

        mockMvc.perform(
                MockMvcRequestBuilders.post(ENDPOINT_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CustomUtils.asJsonString(AppointmentBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(appointmentService, Mockito.times(1)).save(ArgumentMatchers.any(AppointmentDto.class));
        Mockito.verifyNoMoreInteractions(appointmentService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(appointmentService.update(ArgumentMatchers.any(), ArgumentMatchers.anyInt())).thenReturn(AppointmentBuilder.getDto());

        mockMvc.perform(
                MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CustomUtils.asJsonString(AppointmentBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(appointmentService, Mockito.times(1)).update(ArgumentMatchers.any(AppointmentDto.class), ArgumentMatchers.anyInt());
        Mockito.verifyNoMoreInteractions(appointmentService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(appointmentService).deleteById(ArgumentMatchers.anyInt());
        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CustomUtils.asJsonString(AppointmentBuilder.getIds()))).andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(appointmentService, Mockito.times(1)).deleteById(Mockito.anyInt());
        Mockito.verifyNoMoreInteractions(appointmentService);
    }
}
