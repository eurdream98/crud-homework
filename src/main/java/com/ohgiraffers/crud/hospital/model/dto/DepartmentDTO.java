package com.ohgiraffers.crud.hospital.model.dto;

public class DepartmentDTO {
    private int departmentCode;
    private String departmentName;

    public DepartmentDTO() {
    }

    public DepartmentDTO(int departmentCode, String departmentName) {
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
    }

    public int getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(int departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "departmentCode=" + departmentCode +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
