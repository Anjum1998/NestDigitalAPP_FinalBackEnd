package com.example.NestDigitalApp_BackEnd.dao;

import com.example.NestDigitalApp_BackEnd.model.LeaveCounter;
import org.springframework.data.repository.CrudRepository;

public interface LeaveCounterDao extends CrudRepository<LeaveCounter ,Integer> {
}
