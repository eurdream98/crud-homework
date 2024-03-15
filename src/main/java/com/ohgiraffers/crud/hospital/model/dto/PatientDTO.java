package com.ohgiraffers.crud.hospital.model.dto;

public class PatientDTO {
    private int patientCode;
    private String patientName;
    private int patientAge;
    private String patientGender;
    private String patientPhone;
    private String patientEmail;
    private String patientSick;
    private String patientAdmission;
    private int departmentCode;

    public PatientDTO() {
    }

    public PatientDTO(int patientCode, String patientName, int patientAge, String patientGender, String patientPhone, String patientEmail, String patientSick, String patientAdmission, int departmentCode) {
        this.patientCode = patientCode;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientGender = patientGender;
        this.patientPhone = patientPhone;
        this.patientEmail = patientEmail;
        this.patientSick = patientSick;
        this.patientAdmission = patientAdmission;
        this.departmentCode = departmentCode;
    }

    public int getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(int patientCode) {
        this.patientCode = patientCode;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientSick() {
        return patientSick;
    }

    public void setPatientSick(String patientSick) {
        this.patientSick = patientSick;
    }

    public String getPatientAdmission() {
        return patientAdmission;
    }

    public void setPatientAdmission(String patientAdmission) {
        this.patientAdmission = patientAdmission;
    }

    public int getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(int departmentCode) {
        this.departmentCode = departmentCode;
    }

    @Override
    public String toString() {
        return "PatientDTO{" +
                "patientCode=" + patientCode +
                ", patientName='" + patientName + '\'' +
                ", patientAge=" + patientAge +
                ", patientGender='" + patientGender + '\'' +
                ", patientPhone='" + patientPhone + '\'' +
                ", patientEmail='" + patientEmail + '\'' +
                ", patientSick='" + patientSick + '\'' +
                ", patientAdmission='" + patientAdmission + '\'' +
                ", departmentCode=" + departmentCode +
                '}';
    }
}
