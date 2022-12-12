package com.example.NestDigitalApp_BackEnd.dao;

import com.example.NestDigitalApp_BackEnd.model.VisitorLog;
import org.springframework.data.repository.CrudRepository;

public interface VisitorDao extends CrudRepository<VisitorLog,Integer> {
}
