package com.example.NestDigitalApp_BackEnd.dao;

import com.example.NestDigitalApp_BackEnd.model.Employ;
import org.springframework.data.repository.CrudRepository;

public interface EmployDao extends CrudRepository<Employ, Integer> {
}
