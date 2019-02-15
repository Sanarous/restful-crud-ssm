package com.study.ssm.test.pageHelper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
public class TestPageHelper {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 测试分页插件
     */
    @Test
    public void test01(){
        EmployeeExample example = new EmployeeExample();
        example.createCriteria();
        PageHelper.startPage(1, 10);
        List<Employee> employees = employeeMapper.selectByExampleWithDept(example);
        PageInfo<Employee> pf = new PageInfo<>(employees);
        List<Employee> list = pf.getList();
        for (Employee emp : list) {
            System.out.println(emp);
        }
        System.out.println("当前页码：" + pf.getPageNum());
        System.out.println("总页数:" + pf.getPages());
        System.out.println("下一页:" + pf.getNextPage());
        System.out.println("页面大小:" + pf.getPageSize());
        System.out.println(pf.getNavigateFirstPage());
        System.out.println(pf.getNavigateLastPage());
        System.out.println(pf.getNavigatepageNums().toString());
        System.out.println(pf.getNavigatePages());
    }
}
