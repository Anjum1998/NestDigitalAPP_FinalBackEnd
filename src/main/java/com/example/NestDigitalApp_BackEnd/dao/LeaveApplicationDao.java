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

    @Query(value = "SELECT  e.`empcode`, e.`empname`,l.leavetype,l.apply_date,l.from_date,l.to_date,l.status,l.remarks,l.empid  FROM `empdetails` e JOIN leaveapplication l ON e.id=l.empid",nativeQuery = true)
    List<Map<String,String>> ViewAllLeave();

    @Modifying
    @Transactional
    @Query(value = "UPDATE `leaveapplication` SET `status`= :status WHERE `empid`= :empid AND `id`= :id",nativeQuery = true)
    void UpdateStatus(@Param("empid") Integer empid,@Param("status") Integer status,@Param("id") Integer id);


    @Modifying
    @Transactional
    @Query(value = "UPDATE `leaveapplication` SET `status`= 1 WHERE `empid`= :empid",nativeQuery = true)
    void AcceptLeave(@Param("empid") Integer empid);


    @Query(value = "SELECT `id`, `apply_date`, `empid`, `from_date`, `leavetype`, `remarks`, `status`, `to_date` FROM `leaveapplication` WHERE `id`= :id",nativeQuery = true)
    List<LeaveApplication> SearchStatus(@Param("id") Integer id);

    @Query(value = "SELECT `id`, `apply_date`, `empid`, `from_date`, `leavetype`, `remarks`, `status`, `to_date` FROM `leaveapplication` WHERE `empid`= :empid",nativeQuery = true)
    List<LeaveApplication> CountStatus(@Param("empid") Integer empid);


    @Query(value = "SELECT * FROM `leaveapplication` WHERE `empid`= :empid ORDER BY `id` DESC",nativeQuery = true)
    List<LeaveApplication> id(@Param("empid") Integer empid);
}
