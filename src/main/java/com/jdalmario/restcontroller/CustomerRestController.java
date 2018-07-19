package com.jdalmario.restcontroller;

import com.jdalmario.entity.Customer;
import com.jdalmario.service.CustomerEmployeeRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerEmployeeRetrievalService customerEmployeeRetrievalService;

    @RequestMapping(value = "/customers/${id}", method = RequestMethod.GET)
    Customer getCustomer(@PathVariable(value = "id") Long id) {
        Customer customer = this.customerEmployeeRetrievalService.getCustomerById(id);
        return customer;
    }
}
