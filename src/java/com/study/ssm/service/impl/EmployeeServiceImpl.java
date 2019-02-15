package com.study.ssm.service.impl;

import com.study.ssm.dao.EmployeeMapper;
import com.study.ssm.pojo.Employee;
import com.study.ssm.pojo.EmployeeExample;
import com.study.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 获取员工信息
     * @return
     */
    @Override
    public List<Employee> getEmps() {
        EmployeeExample example = new EmployeeExample();
        example.createCriteria();
        List<Employee> employees = employeeMapper.selectByExampleWithDept(example);
        return employees;
    }

    /**
     * 增加员工信息
     * @param employee
     */
    @Override
    public void addEmp(Employee employee) {
        //增加员工信息之前先查出所有部门名
        employeeMapper.insertSelective(employee);
    }

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    @Override
    public Employee getEmpById(Integer id) {
        Employee employee = employeeMapper.selectByPrimaryKeyWithDept(id);
        return employee;
    }

    /**
     * 修改员工信息
     * @param employee
     * @return
     */
    @Override
    public void updateEmp(Integer id,Employee employee) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        //设置更新哪个id
        criteria.andEmpIdEqualTo(id);
        //更新字段
        Employee emp = new Employee();
        emp.setGender(employee.getGender());
        emp.setEmail(employee.getEmail());
        emp.setdId(employee.getdId());
        employeeMapper.updateByExampleSelective(emp,example);
    }

    /**
     * 删除员工信息
     * @param id
     */
    @Override
    public void deleteEmp(Integer id) {
        employeeMapper.deleteByPrimaryKey(id);
    }
}
