package com.ohgiraffers.crud.hospital.model.dao;

import com.ohgiraffers.crud.hospital.model.dto.DepartmentDTO;
import com.ohgiraffers.crud.hospital.model.dto.PatientDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface PatientMapper {
    List<PatientDTO> selectAllPatient();

    void insertPatient(PatientDTO patientDTO);

    List<DepartmentDTO> bringDepartment();

    PatientDTO selectOne(int patientCode);

    void updateOne(PatientDTO patientDTO);
}
