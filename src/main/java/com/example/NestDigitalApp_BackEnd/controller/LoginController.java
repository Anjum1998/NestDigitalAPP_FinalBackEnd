package com.example.NestDigitalApp_BackEnd.controller;

import com.example.NestDigitalApp_BackEnd.dao.LoginDao;
import com.example.NestDigitalApp_BackEnd.model.EmpLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private LoginDao dao;

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
}
