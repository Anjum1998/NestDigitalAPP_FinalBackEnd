package com.example.NestDigitalApp_BackEnd.controller;

import com.example.NestDigitalApp_BackEnd.dao.LoginDao;
import com.example.NestDigitalApp_BackEnd.dao.VisitorDao;
import com.example.NestDigitalApp_BackEnd.model.EmpLog;
import com.example.NestDigitalApp_BackEnd.model.VisitorLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private LoginDao dao;
    @Autowired
    private VisitorDao d;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/logemp",consumes = "application/json",produces = "application/json")
    public Map<String,String> EmployLog(@RequestBody EmpLog l)
    {
        System.out.println(l.getEmpid());
        System.out.println(l.getDate().toString());
        System.out.println(l.getEntry_datetime().toString());
        System.out.println(l.getExit_datetime().toString());
        dao.save(l);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewallemplog")
    public List<EmpLog> ViewAllEMpLog()
    {
        return (List<EmpLog>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewdailyemplog",consumes = "application/json",produces = "application/json")
    public List<EmpLog> ViewDailyEmpLog(@RequestBody EmpLog e)
    {
        return (List<EmpLog>) dao.ViewDailyEmpLog(e.getDate());
    }



    @CrossOrigin(origins = "*")
    @PostMapping(path = "/logvisitor",consumes = "application/json",produces = "application/json")
    public Map<String,String> VisitorLog(@RequestBody VisitorLog v)
    {
        System.out.println(v.getName().toString());
        System.out.println(v.getWhomtomeet().toString());
        System.out.println(v.getPurpose().toString());
        System.out.println(v.getEntry_datetime().toString());
        System.out.println(v.getExit_datetime().toString());
        d.save(v);
        HashMap<String,String> map =new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewallvisitorlog")
    public List<VisitorLog> ViewAllVisitorLog()
    {
        return (List<VisitorLog>) d.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewDailyVisitorlog",consumes = "application/json",produces = "application/json")
    public List<VisitorLog> ViewDailyVisitorLog(@RequestBody VisitorLog v)
    {
        return (List<VisitorLog>) d.ViewDailyVisitorLog(v.getDate());
    }
}
