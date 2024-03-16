package com.ohgiraffers.crud.hospital.model.service;

import com.ohgiraffers.crud.configuration.application.CrudHomeworkApplication;
import com.ohgiraffers.crud.hospital.model.dto.DepartmentDTO;
import com.ohgiraffers.crud.hospital.model.dto.PatientDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@ContextConfiguration(classes={CrudHomeworkApplication.class})
public class PatientServiceTests {
    @Autowired
    PatientService patientService;

    @Test
    public void  전체_환자_조회_테스트(){
        List<PatientDTO> patientDTOS = patientService.selectAllPatient();
        assertNotNull(patientDTOS);
    }

    @Test
    public void 현재_데이터베이스에_있는_진료과_정보_가져오기(){
        List<DepartmentDTO> departmentDTOS = patientService.bringDepartment();
        assertNotNull(departmentDTOS);
    }

    @Test
    @Transactional
    public void 환자_정보_추가_테스트(){
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setPatientName("테스트 환자");
        patientDTO.setPatientAge(25);
        patientDTO.setPatientGender("남");
        patientDTO.setPatientPhone("010-2222-2222");
        patientDTO.setPatientEmail("@naver");
        patientDTO.setPatientSick("여기가 아파");
        patientDTO.setPatientAdmission("Y");
        patientDTO.setDepartmentCode(3);


        assertDoesNotThrow(() -> patientService.insertPatient(patientDTO));
    }
}
