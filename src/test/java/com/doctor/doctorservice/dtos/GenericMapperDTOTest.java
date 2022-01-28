package com.doctor.doctorservice.dtos;

import com.doctor.doctorservice.models.Doctor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericMapperDTOTest {

    Doctor doctor = new Doctor(510.5F, 1, 1, 1, 1);
    SimpleDoctorDTO simpleDoctorDTO = new SimpleDoctorDTO(1L,1, 510.5F, 1, 1, 1);
    @Test
    void singleInstance() {

    }

    @Test
    void mapToSimpleDoctorDTO() {
        GenericMapperDTO genericMapperDTO = GenericMapperDTO.singleInstance();
        SimpleDoctorDTO doctorDTO = genericMapperDTO.mapToSimpleDoctorDTO(doctor);
        Assertions.assertEquals(doctorDTO.getFee(),510.5F);
    }
}