package com.reactJava.repository;

import com.reactJava.entity.Customers;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customers,Long> {

}
