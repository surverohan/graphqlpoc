package com.spike.graphql.resolver;

import org.springframework.stereotype.Service;

import com.spike.graphql.exception.EmployeeNotFoundException;
import com.spike.graphql.model.Address;
import com.spike.graphql.model.Employee;
import com.spike.graphql.repository.AddressRepository;
import com.spike.graphql.repository.EmployeeRepository;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;

/**
 * Created by Rohan Surve on 01/31/2020. This class is represents Comtroller
 * with Query Schema mapping for avoiding *.graphql/*.graphqls files
 */
@Service
@GraphQLApi
public class EmployeeResolver {
	private AddressRepository addressRepository;
	private EmployeeRepository employeeRepository;

	public EmployeeResolver(AddressRepository addressRepository, EmployeeRepository employeeRepository) {
		this.addressRepository = addressRepository;
		this.employeeRepository = employeeRepository;

	}

	@GraphQLMutation(name = "createAddress")
	public Address newAddress(@GraphQLArgument(name = "address") Address address) {
		addressRepository.save(address);
		return address;
	}

	@GraphQLMutation(name = "createEmployee")
	public Employee newEmployee(@GraphQLArgument(name = "employee") Employee employee,
			@GraphQLArgument(name = "address") Address address) {
		employee.setAddressId(address.getId());
		addressRepository.save(address);
		employeeRepository.save(employee);

		return employee;
	}

	@GraphQLMutation(name = "deleteEmployee")
	public boolean deleteEmployee(@GraphQLArgument(name = "employee_id") Long id) {
		employeeRepository.deleteById(id);
		return true;
	}

	@GraphQLMutation(name = "updateEmloyee")
	public Employee updateEmployeeCode(@GraphQLArgument(name = "employee_code") Integer code,
			@GraphQLArgument(name = "employee_id") Long id) {
		Employee book = employeeRepository.findById(id).get();
		if (book == null) {
			throw new EmployeeNotFoundException("The Employee to be updated was found", id);
		}
		book.setCode(code);

		employeeRepository.save(book);

		return book;
	}

	@GraphQLQuery(name = "getAddress")
	public Address getAddress(@GraphQLArgument(name = "id") Long id,
			@GraphQLArgument(name = "street_Name") String street_name) {
		System.out.println("street_name ...."+street_name);
		return addressRepository.findById(id).get();
	}

	@GraphQLQuery(name = "findAllEmployees")
	public Iterable<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}

	@GraphQLQuery(name = "findAllAddresses")
	public Iterable<Address> findAllAddresses() {
		return addressRepository.findAll();
	}

	@GraphQLQuery(name = "countEmployees")
	public long countEmployees() {
		return employeeRepository.count();
	}

	@GraphQLQuery(name = "countAddresses")
	public long countAddresses() {
		return addressRepository.count();
	}
}
