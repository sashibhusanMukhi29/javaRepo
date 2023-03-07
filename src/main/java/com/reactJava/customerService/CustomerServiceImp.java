package com.reactJava.customerService;

import java.util.List;
import java.util.stream.Collectors;

import com.reactJava.dto.CustomerDto;
import com.reactJava.entity.Customers;
import com.reactJava.exception.CustomerNotFoundException;
import com.reactJava.repository.CustomerRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CustomerServiceImp implements CustomerService{
	@Autowired
	private CustomerRepository repository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CustomerDto addCustomersDtoDetails(CustomerDto customerDto) {
		Customers customer = this.customerDtoToCustomers(customerDto);
		Customers save = this.repository.save(customer);
		CustomerDto cutomersToCustomersDto = this.cutomersToCustomersDto(save);
		return cutomersToCustomersDto;
	}

	@Override
	public List<CustomerDto> viewAllCustomerDtoDetails() {
		List<Customers> findAll = this.repository.findAll();
		List<CustomerDto> collect = findAll.stream().map((e)->this.cutomersToCustomersDto(e)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public CustomerDto updateCustomerDtoDetails(Long id, CustomerDto customerDto) {
		Customers customer = this.repository.findById(id).orElseThrow(()-> new CustomerNotFoundException(" customer not found with id  "+ id));
		customer.setName(customerDto.getName());
		customer.setEmail(customerDto.getEmail());
		customer.setPassword(customerDto.getPassword());
		customer.setAddress(customerDto.getAddress());
		Customers save = this.repository.save(customer);
		CustomerDto cutomersToCustomersDto = this.cutomersToCustomersDto(save);
		
		return cutomersToCustomersDto ;
	}

	@Override
	public CustomerDto viewCustomerById(Long id) {
		Customers customers = this.repository.findById(id).orElseThrow(()->new CustomerNotFoundException(" customer not found with id  "+ id));
		CustomerDto custo = this.cutomersToCustomersDto(customers);
		
		return custo;
	}

	@Override
	public Long deleteCustomerDetails(Long id) {
		Customers customers = this.repository.findById(id).orElseThrow(()->new CustomerNotFoundException(" customer not found with id  "+ id));
		this.repository.deleteById(customers.getId());
		return id;
	}
	public Customers customerDtoToCustomers( CustomerDto customerDto)
	{
		Customers customer = this.modelMapper.map(customerDto,Customers.class);
		return customer;
	}
	public CustomerDto cutomersToCustomersDto( Customers customers)
	{
		CustomerDto customerDto = this.modelMapper.map(customers,CustomerDto.class);
		return customerDto;
	}

}
