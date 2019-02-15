package com.study.ssm.service.impl;

import com.study.ssm.dao.DepartmentMapper;
import com.study.ssm.pojo.Department;
import com.study.ssm.pojo.DepartmentExample;
import com.study.ssm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> getDepts() {
        DepartmentExample example = new DepartmentExample();
        example.createCriteria();
        List<Department> departments = departmentMapper.selectByExample(example);
        return departments;
    }
}
