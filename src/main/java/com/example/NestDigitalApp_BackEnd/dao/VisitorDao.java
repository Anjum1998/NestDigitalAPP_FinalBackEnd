package com.example.NestDigitalApp_BackEnd.dao;

import com.example.NestDigitalApp_BackEnd.model.VisitorLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VisitorDao extends CrudRepository<VisitorLog,Integer> {

    @Query(value = "SELECT `id`, `entry_datetime`, `exit_datetime`, `name`, `purpose`, `whomtomeet`, `date` FROM `visitorlog` WHERE `date`= :date",nativeQuery = true)
    List<VisitorLog> ViewDailyVisitorLog(@Param("date") String date);
}
