package com.study.ssm.test.mapper;

import com.study.ssm.dao.EmployeeMapper;
import com.study.ssm.pojo.Employee;
import com.study.ssm.pojo.EmployeeExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestMapper {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 测试Mybatis连接数据库
     */
    @Test
    public void test01(){
        EmployeeExample example = new EmployeeExample();
        example.createCriteria();
        List<Employee> employees = employeeMapper.selectByExampleWithDept(example);
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
