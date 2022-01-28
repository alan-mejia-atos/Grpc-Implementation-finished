package com.doctor.doctorservice.controller;

import com.doctor.doctorservice.dtos.SimpleDoctorDTO;
import com.doctor.doctorservice.models.Doctor;
import com.doctor.doctorservice.serviceImpl.DoctorServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DoctorController.class)
class DoctorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DoctorServiceImpl doctorService;

    ModelMapper modelMapper = new ModelMapper();

    Doctor mockDoctor1 = new Doctor(510.15F, 2, 1, 2, 1);

    Doctor mockDoctor2 = new Doctor(210.9F, 3, 2, 2, 1);


    @Test
    @Description("Get One Doctor Asynchronously")
    void getOneDoctoTest() throws Exception{
        SimpleDoctorDTO dto = modelMapper.map(mockDoctor1, SimpleDoctorDTO.class);
        Mockito.when(doctorService.getOneDoctorDTO(Mockito.anyLong())).thenReturn(CompletableFuture.completedFuture(dto));

        ObjectMapper mapper = new ObjectMapper();

        String body = mapper.writeValueAsString(dto);

        MvcResult response =
                this.mockMvc.perform(get("http://localhost:8081/api/v1/doctors/10000").accept(MediaType.APPLICATION_JSON) )
                        .andExpect(request().asyncStarted())
                        .andExpect(status().is2xxSuccessful())
                        .andReturn();
        this.mockMvc.perform(asyncDispatch(response))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(body));
    }

    @Test
    @Description("Get ALL Test")
    void gerAllDoctors()throws Exception{
        SimpleDoctorDTO dto = modelMapper.map(mockDoctor1, SimpleDoctorDTO.class);
        List<SimpleDoctorDTO> dtosList = new ArrayList<>();
        dtosList.add(dto);
        Mockito.when(doctorService.getAllDTO()).thenReturn(CompletableFuture.completedFuture(dtosList));


        ObjectMapper mapper = new ObjectMapper();

        String body = mapper.writeValueAsString(dtosList);

        MvcResult response =
                this.mockMvc.perform(get("http://localhost:8081/api/v1/doctors/").accept(MediaType.APPLICATION_JSON) )
                        .andExpect(request().asyncStarted())
                        .andExpect(status().is2xxSuccessful())
                        .andReturn();
        this.mockMvc.perform(asyncDispatch(response))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(body));
    }

    @Test
    @Description("Post One User Asynchronously")
    public void shouldPostAUser()throws Exception{
        given(doctorService.save(Mockito.any()))
                .willReturn(CompletableFuture.completedFuture(mockDoctor1));

        ObjectMapper objectMapper = new ObjectMapper();

        String body = objectMapper.writeValueAsString(mockDoctor1);

        MvcResult result = this.mockMvc.perform(post("http://localhost:8081/api/v1/doctors")
                        .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(request().asyncStarted())
                .andExpect(status().is2xxSuccessful())
                .andReturn();


        this.mockMvc.perform(asyncDispatch(result))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(body,false));
    }

    @Test
    @Description("Update One Doctor Asynchronously")
    public void shouldUpdateUser()throws Exception{
        //SimpleUserDTO dto = modelMapper.map(mockUser,SimpleUserDTO.class);
        given(doctorService.updateDoctor(Mockito.any(),Mockito.anyLong()))
                .willReturn(CompletableFuture.completedFuture(mockDoctor1));

        ObjectMapper objectMapper = new ObjectMapper();

        String body = objectMapper.writeValueAsString(mockDoctor1);


        MvcResult result = this.mockMvc.perform(put("http://localhost:8081/api/v1/doctors/44")
                        .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(request().asyncStarted())
                .andExpect(status().is2xxSuccessful())
                .andReturn();


        this.mockMvc.perform(asyncDispatch(result))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(1))
                .andExpect(jsonPath("$.*",hasSize(10)))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(body,false));
    }

    @Test
    @Description("Delete one Doctor Asynchronously")
    public void deleteUserDTOtest()throws Exception{
        given(doctorService.deleteUser(Mockito.anyLong()))
                .willReturn(CompletableFuture.completedFuture(true));

        ObjectMapper objectMapper = new ObjectMapper();

        String body = objectMapper.writeValueAsString(true);


        MvcResult result = this.mockMvc.perform(delete("http://localhost:8081/api/v1/doctors/44")
                        .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(request().asyncStarted())
                .andExpect(status().is2xxSuccessful())
                .andReturn();


        this.mockMvc.perform(asyncDispatch(result))
                .andDo(print())
                .andExpect(status().isOk());


    }


}