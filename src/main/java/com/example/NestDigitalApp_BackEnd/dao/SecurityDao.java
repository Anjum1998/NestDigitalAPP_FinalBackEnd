package com.example.NestDigitalApp_BackEnd.dao;

import com.example.NestDigitalApp_BackEnd.model.Security;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecurityDao extends CrudRepository<Security,Integer> {


    @Query(value = "SELECT `id`, `empcode`, `name`, `password`, `username` FROM `securitydetail` WHERE `username`= :username AND `password`= :password",nativeQuery = true)
    List<Security> SecurityLogin(@Param("username") String username,@Param("password") String password);

    @Query(value = "SELECT `id`, `empcode`, `name`, `password`, `username` FROM `securitydetail` WHERE `id`= :id",nativeQuery = true)
    List<Security> SecurityViewById(@Param("id") Integer id);
}
