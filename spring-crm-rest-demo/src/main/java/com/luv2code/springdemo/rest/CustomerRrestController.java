package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.luv2code.springdemo.entity.*;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRrestController {

	
	@Autowired 
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer>getCustomers(){
		
		return customerService.getCustomers(); 
		}
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId)
	{
		return customerService.getCustomer(customerId);
	}
	@PostMapping ("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	@PutMapping ("/customer")
	public Customer updateCustomer(@RequestBody Customer theCustomer)
	{
		System.out.println("a7a");

		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		Customer tempCustomer = customerService.getCustomer(customerId);
		
		// throw exception if null
		
		if (tempCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		}
				
		customerService.deleteCustomer(customerId);
		
		return "Deleted customer id - " + customerId;
	}
}
