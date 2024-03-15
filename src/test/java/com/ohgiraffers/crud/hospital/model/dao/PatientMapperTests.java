package com.ohgiraffers.crud.hospital.model.dao;

import com.ohgiraffers.crud.configuration.application.CrudHomeworkApplication;
import com.ohgiraffers.crud.hospital.model.dto.PatientDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ContextConfiguration(classes={CrudHomeworkApplication.class})
public class PatientMapperTests {
    @Autowired
    private PatientMapper patientMapper;

    @Test
    public void 전체_환자_조회_매핑_테스트(){
        List<PatientDTO> list = patientMapper.selectAllPatient();
        assertNotNull(list);
    }

    @Test
    @Transactional
    @DisplayName("환자_정보_추가_테스트")
    public void insertPatient(){
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setPatientName("테스트 환자");
        patientDTO.setPatientAge(27);
        patientDTO.setPatientGender("남");
        patientDTO.setPatientPhone("010-0000-0000");
        patientDTO.setPatientEmail("euxxxxx98@naver.com");
        patientDTO.setPatientSick("편도염");
        patientDTO.setPatientAdmission("Y");
        patientDTO.setDepartmentCode(3);

        assertDoesNotThrow(()->patientMapper.insertPatient(patientDTO));
    }

}
