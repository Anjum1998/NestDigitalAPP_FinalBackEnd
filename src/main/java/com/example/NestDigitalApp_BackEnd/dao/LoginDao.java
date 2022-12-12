package com.example.NestDigitalApp_BackEnd.dao;

import com.example.NestDigitalApp_BackEnd.model.EmpLog;

import org.springframework.data.repository.CrudRepository;

public interface LoginDao extends CrudRepository<EmpLog,Integer> {


}
