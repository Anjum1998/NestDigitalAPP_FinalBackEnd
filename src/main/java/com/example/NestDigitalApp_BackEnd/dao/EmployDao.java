package com.example.NestDigitalApp_BackEnd.dao;

import com.example.NestDigitalApp_BackEnd.model.Employ;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployDao extends CrudRepository<Employ, Integer> {

    @Query(value = "SELECT `id`, `designation`, `empcode`, `empname`, `password`, `salary`, `username` FROM `empdetails` WHERE `empcode`= :empcode",nativeQuery = true)
    List<Employ> EmpSearch(@Param("empcode") Integer empcode);
}
