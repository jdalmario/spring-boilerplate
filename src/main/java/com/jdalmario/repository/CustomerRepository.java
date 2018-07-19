package com.jdalmario.repository;

import com.jdalmario.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findById(Long id);

    Customer findAllByIdIsGreaterThan(Long id);
}
