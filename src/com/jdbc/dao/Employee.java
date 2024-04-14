package com.jdbc.dao;

public class Employee {
    private int id;
    private String qualification;
    private String emailId;
    private String mobileNo;
    private String name;

    public Employee(){
    }

    public Employee(int id, String qualification, String emailId, String mobileNo, String name) {
        this.id = id;
        this.qualification = qualification;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", qualification='" + qualification + '\'' +
                ", emailId='" + emailId + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
