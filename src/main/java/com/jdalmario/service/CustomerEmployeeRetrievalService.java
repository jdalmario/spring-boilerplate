package com.jdalmario.service;

import com.jdalmario.entity.Customer;
import com.jdalmario.entity.Employee;
import com.jdalmario.repository.CustomerRepository;
import com.jdalmario.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerEmployeeRetrievalService {

    private CustomerRepository customerRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public CustomerEmployeeRetrievalService(CustomerRepository customerRepository, EmployeeRepository employeeRepository) {
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployee() {
        Iterable<Employee> iterable = this.employeeRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC, "firstName")));
        List<Employee> employeeList = new ArrayList<>();
        iterable.forEach(employee -> {
            employeeList.add(employee);
        });
        return employeeList;
    }

    public List<Customer> getAllCustomer() {
        Iterable<Customer> iterable = this.customerRepository.findAll();
        List<Customer> customerList = new ArrayList<>();
        iterable.forEach(customer -> {
            customerList.add(customer);
        });
        return customerList;
    }

    public Customer getCustomerById(Long id) {
        Customer customer = this.customerRepository.findById(id);
        return customer;
    }

    public Customer getCustomerGreatenThanId(Long id) {
        Customer customer = this.customerRepository.findAllByIdIsGreaterThan(id);
        return customer;
    }
}
