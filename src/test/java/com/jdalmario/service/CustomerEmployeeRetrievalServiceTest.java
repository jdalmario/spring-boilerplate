package com.jdalmario.service;


import com.jdalmario.repository.CustomerRepository;
import com.jdalmario.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerEmployeeRetrievalServiceTest {

    @TestConfiguration
    static class CustomerEmployeeServiceImplTestContextConfiguration {
        @Bean
        public CustomerEmployeeRetrievalService employeeService() {
            return new CustomerEmployeeRetrievalService(customerRepository, employeeRepository);
        }
    }

    @Autowired
    private CustomerEmployeeRetrievalService customerEmployeeRetrievalService;

    @MockBean
    private static CustomerRepository customerRepository;

    @MockBean
    private static EmployeeRepository employeeRepository;


    @Test
    public void something() {
        assert 1 == 1;
    }

}