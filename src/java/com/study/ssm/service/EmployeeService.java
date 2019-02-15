package com.study.ssm.service;

import com.study.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getEmps();

    public void addEmp(Employee employee);

    public Employee getEmpById(Integer id);

    public void updateEmp(Integer id,Employee employee);

    public void deleteEmp(Integer id);
}
