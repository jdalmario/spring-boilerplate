package com.jdalmario.controller;

import com.jdalmario.entity.Customer;
import com.jdalmario.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customersList;

    @RequestMapping(method = RequestMethod.GET)
    public String getCustomers(Model model) {
        Iterable<Customer> itList = this.customersList.findAll();
        List<Customer> customerList = new ArrayList();
        itList.forEach(customer -> {
            customerList.add(customer);
        });
        model.addAttribute("customerList", customerList);
        return "customers";
    }
}
