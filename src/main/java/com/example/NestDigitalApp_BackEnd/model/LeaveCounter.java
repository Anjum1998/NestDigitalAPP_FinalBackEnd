package com.example.NestDigitalApp_BackEnd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "leavecount")
public class LeaveCounter {

    @Id
    @GeneratedValue
    private int id;
    private int empid;
    private int year;
    private int casual=20;
    private int sick=7;
    private int other=3;

    public LeaveCounter() {
    }

    public LeaveCounter(int id, int empid, int year, int casual, int sick, int other) {
        this.id = id;
        this.empid = empid;
        this.year = year;
        this.casual = casual;
        this.sick = sick;
        this.other = other;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCasual() {
        return casual;
    }

    public void setCasual(int casual) {
        this.casual = casual;
    }

    public int getSick() {
        return sick;
    }

    public void setSick(int sick) {
        this.sick = sick;
    }

    public int getOther() {
        return other;
    }

    public void setOther(int other) {
        this.other = other;
    }
}
