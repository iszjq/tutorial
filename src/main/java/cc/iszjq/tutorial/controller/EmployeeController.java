package cc.iszjq.tutorial.controller;


import cc.iszjq.tutorial.dao.EmployeeDao;
import cc.iszjq.tutorial.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    //员工列表页面
    @GetMapping("/emps")
    public String list(ModelMap map) {
        Collection<Employee> employees = employeeDao.getAll();
        map.put("emps", employees);
        return "emp/list";
    }
}
