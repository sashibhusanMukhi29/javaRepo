package com.reactJava.controller;

import com.reactJava.customerService.CustomerService;
import com.reactJava.dto.CustomerDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@PostMapping("/customer/add")
	public ResponseEntity<CustomerDto> addCustomer(@Valid @RequestBody CustomerDto customerDto) {
		
          CustomerDto addCustomersDtoDetails = this.customerService.addCustomersDtoDetails(customerDto);
		return new ResponseEntity<CustomerDto>(addCustomersDtoDetails,HttpStatus.OK);
          
	}
	private ResponseEntity<>
}
