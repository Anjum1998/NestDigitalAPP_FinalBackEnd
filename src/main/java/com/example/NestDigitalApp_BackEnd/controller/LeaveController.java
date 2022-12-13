package com.example.NestDigitalApp_BackEnd.controller;

import com.example.NestDigitalApp_BackEnd.dao.LeaveApplicationDao;
import com.example.NestDigitalApp_BackEnd.model.LeaveApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LeaveController {

    @Autowired
    private LeaveApplicationDao dao;

    Date currentdate=new Date();

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/leaveapply",produces = "application/json",consumes = "application/json")
    public Map<String,String> ApplyLeave(@RequestBody LeaveApplication l)
    {
        dao.save(l);
        l.setApply_date(String.valueOf(currentdate));
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewallleavebyemp")
    public List<Map<String,String>> ViewAllLeave()
    {
        return (List<Map<String, String>>) dao.ViewAllLeave();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/update",consumes = "application/json",produces = "application/json")
    public Map<String,String> UpdateStatus(@RequestBody LeaveApplication l)
    {
        String empid=String.valueOf(l.getEmpid());
        String status=l.getStatus().toString();
        System.out.println(empid);
        System.out.println(status);
        dao.UpdateStatus(l.getEmpid(),l.getStatus());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }


}
