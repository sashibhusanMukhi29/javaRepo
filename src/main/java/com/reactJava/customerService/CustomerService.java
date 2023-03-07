package com.reactJava.customerService;

import java.util.List;

import com.reactJava.dto.CustomerDto;

public interface CustomerService {
	CustomerDto addCustomersDtoDetails(CustomerDto customerDto);
	List<CustomerDto> viewAllCustomerDtoDetails();
	CustomerDto updateCustomerDtoDetails(Long id ,CustomerDto customerDto);
	CustomerDto viewCustomerById(Long id );
	Long deleteCustomerDetails(Long id );

}
