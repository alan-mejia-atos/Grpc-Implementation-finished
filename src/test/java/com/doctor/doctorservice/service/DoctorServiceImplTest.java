//package com.doctor.doctorservice.service;
//
//import com.doctor.doctorservice.dtos.SimpleDoctorDTO;
//import com.doctor.doctorservice.models.Doctor;
//import com.doctor.doctorservice.repository.DoctorRepository;
//import com.doctor.doctorservice.serviceImpl.DoctorServiceImpl;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.modelmapper.ModelMapper;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Description;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//
//
//public class DoctorServiceImplTest {
//
//    @Mock
//    private DoctorRepository doctorRepository;
//
//    @InjectMocks
//    private DoctorServiceImpl doctorService;
//
//    private Doctor mockDoctor = new Doctor();
//
//    @BeforeEach
//    public void setup(){
//        MockitoAnnotations.openMocks(this);
//        MockitoAnnotations.initMocks(this);
//        mockDoctor.setModificationTime(new Date());
//        mockDoctor.setStatus(1);
//        mockDoctor.setUserdId(1);
//        mockDoctor.setCreationTime(new Date());
//        mockDoctor.setUserCreator("admin");
//        mockDoctor.setFee(510.5F);
//        mockDoctor.setId(1L);
//        mockDoctor.setSpecialtyId(1);
//    }
//
////    @Test
////    public void getAllDtoTest() throws Exception{
////        ModelMapper modelMapper = new ModelMapper();
////        SimpleDoctorDTO dto = modelMapper.map(mockDoctor, SimpleDoctorDTO.class);
////        List<SimpleDoctorDTO> listadtos = new ArrayList<>();
////        listadtos.add(dto);
////        Mockito.when(doctorService.getAllDTO()).thenReturn(CompletableFuture.completedFuture(listadtos));
////
////        CompletableFuture<List<SimpleDoctorDTO>> result = doctorService.getAllDTO();
////        System.out.println("Termino de procesar la promesa: " + result.isDone());
////        result.join();
////        assertThat(result.get()).hasSize(3);
////        verify(doctorRepository,times(1)).findAll();
////    }
//
//    @Test
//    @Description("Get ALL Test")
//    void gerAllDoctors()throws Exception{
//        ModelMapper modelMapper = new ModelMapper();
//        SimpleDoctorDTO dto = modelMapper.map(mockDoctor, SimpleDoctorDTO.class);
//        List<SimpleDoctorDTO> dtosList = new ArrayList<>();
////        List<Doctor>
//        dtosList.add(dto);
////        Mockito.when(doctorRepository.findAll()).thenReturn()
//        Mockito.when(doctorService.getAllDTO()).thenReturn(CompletableFuture.completedFuture(dtosList));
//        System.out.println("Run async");
//        assertThat(!dtosList.isEmpty());
////
////        CompletableFuture<List<SimpleDoctorDTO>> result = doctorService.getAllDTO();
////        Assertions.assertEquals(result.get().size(),1);
//
//        verify(doctorRepository, times(1)).findAll();
//
////        ObjectMapper mapper = new ObjectMapper();
////
////        String body = mapper.writeValueAsString(dtosList);
////
////        MvcResult response =
////                this.mockMvc.perform(get("http://localhost:8081/api/v1/doctors/").accept(MediaType.APPLICATION_JSON) )
////                        .andExpect(request().asyncStarted())
////                        .andExpect(status().is2xxSuccessful())
////                        .andReturn();
////        this.mockMvc.perform(asyncDispatch(response))
////                .andDo(print())
////                .andExpect(status().isOk())
////                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
////                .andExpect(content().json(body));
//    }
//
//
//
//}
