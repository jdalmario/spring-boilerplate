package com.jdalmario.controller;

import com.jdalmario.service.CustomerEmployeeRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private CustomerEmployeeRetrievalService customerEmployeeRetrievalService;

    @RequestMapping(method = RequestMethod.GET)
    public String employee(Model model) {
        model.addAttribute("employeeList", customerEmployeeRetrievalService.getAllEmployee());
        return "employee";
    }
}
