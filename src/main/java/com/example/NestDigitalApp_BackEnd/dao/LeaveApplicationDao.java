package com.example.NestDigitalApp_BackEnd.dao;

import com.example.NestDigitalApp_BackEnd.model.LeaveApplication;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface LeaveApplicationDao extends CrudRepository<LeaveApplication, Integer> {

    @Query(value = "SELECT  e.`empcode`, e.`empname`,l.leavetype,l.apply_date,l.from_date,l.to_date,l.status  FROM `empdetails` e JOIN leaveapplication l ON e.id=l.empid",nativeQuery = true)
    List<Map<String,String>> ViewAllLeave();

    @Modifying
    @Transactional
    @Query(value = "UPDATE `leaveapplication` SET `status`= :status WHERE `empid`= :empid",nativeQuery = true)
    void UpdateStatus(@Param("empid") Integer empid,@Param("status") int status);
}
