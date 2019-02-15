package com.study.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.ssm.pojo.Department;
import com.study.ssm.pojo.Employee;
import com.study.ssm.service.DepartmentService;
import com.study.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    /**
     * 分页获取所有员工信息
     * @param model
     * @return
     */
    @RequestMapping("/emps/{page}")
    public String getEmps(@PathVariable("page") Integer page, Model model){
        PageHelper.startPage(page,15);
        List<Employee> emps = employeeService.getEmps();
        PageInfo<Employee> pageInfo = new PageInfo<>(emps);
        pageInfo.setNavigatePages(5);
        model.addAttribute("pageInfo",pageInfo);
        return "list";
    }

    /**
     * 去添加员工页面
     * @return
     */
    @RequestMapping("/toaddpage")
    public String toaddpage(Model model){
        //添加员工之前先将部门名查询出来
        List<Department> depts = departmentService.getDepts();
        model.addAttribute("depts",depts);
        return "add";
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    public String addEmps(Employee employee){
        employee.setEmpId(null);
        employeeService.addEmp(employee);
        return "../../index";
    }

    /**
     * 去员工编辑页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toeditpage/{id}")
    public String toEditPage(@PathVariable("id")Integer id,Model model){
        //根据id查询员工信息，并将员工信息回显到edit页面
        Employee emp = employeeService.getEmpById(id);
        //查询所有部门信息
        List<Department> depts = departmentService.getDepts();
        model.addAttribute("depts",depts);
        model.addAttribute("emp",emp);
        return "edit";
    }

    /**
     * 修改员工信息
     * @param employee
     * @return
     */
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.PUT)
    public String updateEmp(@PathVariable("id")Integer id,Employee employee){
        System.out.println(employee);
        employeeService.updateEmp(id,employee);
        return "../../index";
    }

    /**
     * 删除员工信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeService.deleteEmp(id);
        return "../../index";
    }
}
