package com.example.NestDigitalApp_BackEnd.dao;

import com.example.NestDigitalApp_BackEnd.model.EmpLog;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoginDao extends CrudRepository<EmpLog,Integer> {

@Query(value = "SELECT `id`, `date`, `empid`, `entry_datetime`, `exit_datetime` FROM `emplogin` WHERE `date`= :date",nativeQuery = true)
    List<EmpLog> ViewDailyEmpLog(@Param("date") String date);
}
