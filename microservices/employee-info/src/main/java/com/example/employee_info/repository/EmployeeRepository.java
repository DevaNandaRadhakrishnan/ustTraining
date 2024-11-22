package com.example.employee_info.repository;

import com.example.employee_info.entity.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeInfo, Long> {

    public EmployeeInfo findByCode(Long code);
}
