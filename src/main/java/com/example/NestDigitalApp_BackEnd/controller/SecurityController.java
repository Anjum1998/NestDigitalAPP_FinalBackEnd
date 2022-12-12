package com.example.NestDigitalApp_BackEnd.controller;

import com.example.NestDigitalApp_BackEnd.dao.SecurityDao;
import com.example.NestDigitalApp_BackEnd.model.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SecurityController {
    @Autowired
    private SecurityDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addsecurity",consumes = "application/json",produces = "application/json")
    public Map<String,String> AddSecurity(@RequestBody Security s)
    {
        System.out.println(s.getEmpcode());
        System.out.println(s.getName().toString());
        System.out.println(s.getUsername().toString());
        System.out.println(s.getPassword().toString());
        dao.save(s);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;

    }
}
