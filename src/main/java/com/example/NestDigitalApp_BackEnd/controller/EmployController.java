package com.example.NestDigitalApp_BackEnd.controller;

import com.example.NestDigitalApp_BackEnd.dao.EmployDao;
import com.example.NestDigitalApp_BackEnd.model.Employ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployController {

    @Autowired
    private EmployDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemp",consumes = "application/json" ,produces = "application/json")
    public Map<String,String> AddEmploy(@RequestBody Employ e)
    {
        System.out.println(e.getEmpcode());
        System.out.println(e.getEmpname().toString());
        System.out.println(e.getDesignation().toString());
        System.out.println(e.getSalary());
        System.out.println(e.getUsername().toString());
        System.out.println(e.getPassword().toString());
        dao.save(e);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewemp")
    public List<Employ> EmployView()
    {
        return (List<Employ>) dao.findAll();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchemp",consumes = "application/json",produces = "application/json")
    public List<Employ> EmpSearch(@RequestBody Employ e)
    {
        String empcode=String.valueOf(e.getEmpcode());
        System.out.println(empcode);
        return (List<Employ>) dao.EmpSearch(e.getEmpcode());
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/empdelete",consumes = "application/json", produces = "application/json")
    public Map<String,String> DeleteEmploy(@RequestBody Employ e)
    {
        String id=String.valueOf(e.getId());
        System.out.println(id);
        dao.DeleteEmploy(e.getId());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/emplogin" ,consumes = "application/json",produces = "application/json")
    public Map<String,String> EmployLogin(@RequestBody Employ e)
    {
        String username=e.getUsername().toString();
        String password=e.getPassword().toString();
        System.out.println(username);
        System.out.println(password);
        List<Employ> result=(List<Employ>) dao.EmployLogin(e.getUsername(),e.getPassword());
        HashMap<String,String> map=new HashMap<>();
        if (result.size()==0)
        {
            map.put("status","success");
        }
        else{
            int id=result.get(0).getId();
            map.put("empId",String.valueOf(id));
            map.put("status","success");
        }
        return map;
    }

}
