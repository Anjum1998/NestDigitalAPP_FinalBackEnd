package com.example.NestDigitalApp_BackEnd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "leaveapplication")
public class LeaveApplication {
    @Id
    @GeneratedValue
    private int id;
    private int empid;
    private String leavetype;
    private String remarks;
    private String from_date;
    private String to_date;
    private String apply_date;
    private int status;


    public LeaveApplication() {
    }

    public LeaveApplication(int id, int empid, String leavetype, String remarks, String from_date, String to_date, String apply_date, int status) {
        this.id = id;
        this.empid = empid;
        this.leavetype = leavetype;
        this.remarks = remarks;
        this.from_date = from_date;
        this.to_date = to_date;
        this.apply_date = apply_date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getLeavetype() {
        return leavetype;
    }

    public void setLeavetype(String leavetype) {
        this.leavetype = leavetype;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFrom_date() {
        return from_date;
    }

    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }

    public String getTo_date() {
        return to_date;
    }

    public void setTo_date(String to_date) {
        this.to_date = to_date;
    }

    public String getApply_date() {
        return apply_date;
    }

    public void setApply_date(String apply_date) {
        this.apply_date = apply_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
