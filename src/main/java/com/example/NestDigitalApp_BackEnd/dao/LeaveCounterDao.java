package com.example.NestDigitalApp_BackEnd.dao;

import com.example.NestDigitalApp_BackEnd.model.LeaveCounter;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LeaveCounterDao extends CrudRepository<LeaveCounter ,Integer> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE `leavecount` SET `casual`= :casual,`other`= :other,`sick`= :sick WHERE `empid`= :empid",nativeQuery = true)
    void UpdateCounter(@Param("empid") Integer empid,@Param("casual") Integer casual,@Param("other") Integer other,@Param("sick") Integer sick);
}
