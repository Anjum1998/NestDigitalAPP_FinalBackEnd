package com.example.NestDigitalApp_BackEnd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emplogin")
public class EmpLog {
    @Id
    @GeneratedValue
    private int id;
    private int empid;
    private String date;
    private String entry_datetime;
    private String exit_datetime;

    public EmpLog() {
    }

    public EmpLog(int id, int empid, String date, String entry_datetime, String exit_datetime) {
        this.id = id;
        this.empid = empid;
        this.date = date;
        this.entry_datetime = entry_datetime;
        this.exit_datetime = exit_datetime;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEntry_datetime() {
        return entry_datetime;
    }

    public void setEntry_datetime(String entry_datetime) {
        this.entry_datetime = entry_datetime;
    }

    public String getExit_datetime() {
        return exit_datetime;
    }

    public void setExit_datetime(String exit_datetime) {
        this.exit_datetime = exit_datetime;
    }
}
