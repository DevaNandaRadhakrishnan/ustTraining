package com.example.department_service.service;

import com.example.department_service.entity.DepartmentEntity;
import com.example.department_service.model.DepartmentPojo;
import com.example.department_service.repository.DepartmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements com.example.department_service.service.DepartmentService {

    @Autowired
    DepartmentRepository deptRepo;

    @Override
    public List<DepartmentPojo> getAllDepartments() {
        List<DepartmentEntity> allDept = deptRepo.findAll();
        List<DepartmentPojo> allDeptPojo = new ArrayList<>();
        allDept.forEach(deptEntity -> {
            DepartmentPojo deptPojo = new DepartmentPojo();
            BeanUtils.copyProperties(deptEntity, deptPojo);
            allDeptPojo.add(deptPojo);
        });
        return allDeptPojo;
    }

    @Override
    public DepartmentPojo getDepartment(long deptId) {
        Optional<DepartmentEntity> fetchDeptEntity = deptRepo.findById(deptId);
        DepartmentPojo deptPojo = null;
        if (fetchDeptEntity.isPresent()) {
            deptPojo = new DepartmentPojo();
            BeanUtils.copyProperties(fetchDeptEntity.get(), deptPojo);
        }
        return deptPojo;
    }

    @Override
    public DepartmentPojo addDepartment(DepartmentPojo newDepartmentPojo) {
        DepartmentEntity deptEntity = new DepartmentEntity();
        BeanUtils.copyProperties(newDepartmentPojo, deptEntity);
        deptRepo.saveAndFlush(deptEntity);
        return newDepartmentPojo;
    }

    @Override
    public DepartmentPojo updateDepartment(DepartmentPojo editDepartmentPojo) {
        DepartmentEntity deptEntity = new DepartmentEntity();
        BeanUtils.copyProperties(editDepartmentPojo, deptEntity);
        deptRepo.saveAndFlush(deptEntity);
        return editDepartmentPojo;
    }

    @Override
    public void deleteDepartment(long deptId) {
        Optional<DepartmentEntity> fetchDeptEntity = deptRepo.findById(deptId);
        DepartmentPojo deptPojo = null;
        if (fetchDeptEntity.isPresent()) {
            deptRepo.delete(fetchDeptEntity.get());
            deptPojo = new DepartmentPojo();
            BeanUtils.copyProperties(fetchDeptEntity.get(), deptPojo);
        }
    }
}

