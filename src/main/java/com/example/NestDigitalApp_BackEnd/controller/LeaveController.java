package com.example.NestDigitalApp_BackEnd.controller;

import com.example.NestDigitalApp_BackEnd.dao.LeaveApplicationDao;
import com.example.NestDigitalApp_BackEnd.dao.LeaveCounterDao;
import com.example.NestDigitalApp_BackEnd.model.Employ;
import com.example.NestDigitalApp_BackEnd.model.LeaveApplication;
import com.example.NestDigitalApp_BackEnd.model.LeaveCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LeaveController {

    @Autowired
    private LeaveApplicationDao dao;
    @Autowired
    private LeaveCounterDao ldao;

    Date currentdate=new Date();

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/leaveapply",produces = "application/json",consumes = "application/json")
    public Map<String,String> ApplyLeave(@RequestBody LeaveApplication l)
    {

        l.setApply_date(String.valueOf(currentdate));
        l.setStatus(0);
        dao.save(l);

        List<LeaveApplication> result=(List<LeaveApplication>) dao.id(l.getEmpid());
        HashMap<String,String> map=new HashMap<>();
        if(result.size()==0){
            map.put("status","failed");
        }else{
            int id=result.get(0).getId();
            map.put("id",String.valueOf(id));
            map.put("status","success");
        }
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewallleavebyemp")
    public List<LeaveApplication> ViewAllLeave()
    {
        return(List<LeaveApplication>)dao.findAll();
        //return (List<Map<String, String>>) dao.ViewAllLeave();
    }



    @CrossOrigin(origins = "*")
    @PostMapping(value = "/update",consumes = "application/json",produces = "application/json")
    public Map<String,String> UpdateStatus(@RequestBody LeaveApplication l)
    {
        String empid=String.valueOf(l.getEmpid());
        String status=String.valueOf(l.getStatus());
        System.out.println(empid);
        System.out.println(status);
        dao.UpdateStatus(l.getEmpid(),l.getStatus(),l.getId());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/accept",consumes = "application/json",produces = "application/json")
    public Map<String,String> AcceptLeave(@RequestBody LeaveApplication l)
    {
        dao.AcceptLeave(l.getEmpid());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");

        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchstatus",consumes = "application/json",produces = "application/json")
    public List<LeaveApplication> SearchStatus(@RequestBody LeaveApplication l)
    {
        String id=String.valueOf(l.getId());
        System.out.println(l.getId());
        return (List<LeaveApplication>) dao.SearchStatus(l.getId());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "updatecounter",consumes = "application/json",produces = "application/json")
    public Map<String,String> UpdateCounter(@RequestBody LeaveApplication l) throws ParseException{
        String empid=String.valueOf(l.getEmpid());

        List<LeaveApplication> result1=(List<LeaveApplication>) dao.SearchStatus(l.getEmpid());
        l.setLeavetype(result1.get(0).getLeavetype());

        LocalDate from_date= LocalDate.parse(result1.get(0).getFrom_date());
        LocalDate to_date=LocalDate.parse(result1.get(0).getTo_date());

        long daysDiff= ChronoUnit.DAYS.between(from_date,to_date)+1;
        System.out.println("no of days"+daysDiff);

        List<LeaveCounter> result=(List<LeaveCounter>) ldao.Leaves(l.getEmpid());
        long casual=result.get(0).getCasual();
        long sick=result.get(0).getSick();
        long other=result.get(0).getOther();



        if(l.getLeavetype().equalsIgnoreCase("casual")&& daysDiff<=casual){
            casual=casual-daysDiff;
            sick=sick;
            other=other;

            ldao.UpdateCounter(l.getEmpid(),(int) casual,(int) sick,(int) other);

        } else if (l.getLeavetype().equalsIgnoreCase("sick")&& daysDiff<=sick) {
            casual=casual;
            sick=sick-daysDiff;
            other=other;

            ldao.UpdateCounter(l.getEmpid(),(int) casual,(int) sick,(int) other);
        }else if (l.getLeavetype().equalsIgnoreCase("other") && daysDiff<=other){
            casual=casual;
            sick=sick;
            other=other-daysDiff;
            ldao.UpdateCounter(l.getEmpid(),(int) casual,(int) sick,(int) other);
        }else {
        HashMap<String,String> map=new HashMap<>();
        map.put("leavetype",l.getLeavetype());
        String id=String.valueOf(result.get(0).getEmpid());
        map.put("empid",id);
        map.put("message","np leaves are available");
        return map;
        }
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewcount")
    public List<LeaveCounter> CountView()
    {
        return (List<LeaveCounter>) ldao.findAll();
    }



}
