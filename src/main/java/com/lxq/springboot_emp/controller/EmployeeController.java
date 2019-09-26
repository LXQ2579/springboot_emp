package com.lxq.springboot_emp.controller;

import com.lxq.springboot_emp.entity.Employee;
import com.lxq.springboot_emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @RequestMapping("/add.do")
    public String addEmp(Employee emp) {
    	empService.addEmployee(emp);
        return "redirect:/list.do";
    }

    @RequestMapping("/list.do")
    public String listEmp(Model model) {
        List<Employee> list = empService.findAllEemployee();

        model.addAttribute("empList", list);
        return "list";
    }

    @RequestMapping("/delete.do")
    public String deleteEmp(int id) {
        empService.deleteEmpById(id);
        return "redirect:/list.do";
    }

    @RequestMapping("/query.do")
    public String queryById(Integer id, Model model) {
        if (id != null) {
            Employee emp = empService.findEmpById(id);
            model.addAttribute("employee", emp);
            return "update";
        } else {
            return "add";
        }

    }

    @RequestMapping("/update.do")
    public String updateEmp(Employee emp) {
        empService.updateEmp(emp);

		return "redirect:/list.do";
    }

}
