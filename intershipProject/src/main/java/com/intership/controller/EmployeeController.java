package com.intership.controller;


import com.intership.model.Employee;
import com.intership.service.abstracts.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping
public  class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/admin/employees")
    public String userGetAll(Model model){
        model.addAttribute("employees" , employeeService.findAll());
        return "employees";
    }

    @RequestMapping("/")
    public ModelAndView defaultHome() {
    return new ModelAndView("home");
}

    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @Transactional
    @RequestMapping( "/admin/employees/delete/{employee_id}")
    public String deleteEmployee(@PathVariable Long employee_id){
        this.employeeService.deleteByEmployeeId(employee_id);
        return "redirect:/admin/employees";
    }


    @RequestMapping(value ="/admin/employees/edit/{employee_id}")
    public ModelAndView editEmployeeForm(@PathVariable Long employee_id) {
        ModelAndView modelAndView = new ModelAndView("edit_employee");
        Employee employee = employeeService.getByEmployeeId(employee_id);
        modelAndView.addObject("employee" , employee);
        return modelAndView;
    }


    @Transactional
    @RequestMapping(value = "/admin/employees/edit/save", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        this.employeeService.save(employee);
        return "redirect:/admin/employees";
    }

    @RequestMapping("/admin/employees/edit/newEmployee")
    public String newEmployeeForm(Map<String, Object> model) {
        Employee employee = new Employee();
        model.put("employee", employee);
        return "new_employee";
    }


}
