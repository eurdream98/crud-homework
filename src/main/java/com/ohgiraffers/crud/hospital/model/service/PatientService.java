package com.ohgiraffers.crud.hospital.model.service;

import com.ohgiraffers.crud.hospital.model.dto.DepartmentDTO;
import com.ohgiraffers.crud.hospital.model.dao.PatientMapper;
import com.ohgiraffers.crud.hospital.model.dto.PatientDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;

@Service
public class PatientService{
    private final PatientMapper patientMapper;

    public PatientService(PatientMapper patientMapper) {
        this.patientMapper = patientMapper;
    }

    public List<PatientDTO> selectAllPatient() {
        return patientMapper.selectAllPatient();
    }
    @Transactional
    public void insertPatient(PatientDTO patientDTO) {
        patientMapper.insertPatient(patientDTO);
    }

    public List<DepartmentDTO> bringDepartment() {
        return patientMapper.bringDepartment();
    }

    public PatientDTO selectOne(int patientCode) {
        return patientMapper.selectOne(patientCode);
    }
@Transactional
    public void updateOne(PatientDTO patientDTO) {
         patientMapper.updateOne(patientDTO);
    }
@Transactional
    public void deleteOne(int patientCode) {
        patientMapper.deleteOne(patientCode);
    }
}
