package com.project.localstripe.controller;

import com.project.localstripe.request.CreateCustomerDTO;
import com.project.localstripe.request.UpdateCustomerDTO;
import com.project.localstripe.service.CustomerService;
import com.project.localstripe.service.impl.CustomerServiceImpl;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.CustomerCollection;
import com.stripe.model.CustomerSearchResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/v1/customer")
public class CustomerController{

private final CustomerServiceImpl customerServiceImpl;
public CustomerController(CustomerServiceImpl customerServiceImpl){
this.customerServiceImpl = customerServiceImpl;
}

    @Autowired
    CustomerService customerService;

    @PostMapping("/")
    public Customer createCustomer(@RequestBody CreateCustomerDTO createCustomerDTO) throws StripeException {
        Customer response = customerService.CreateCustomer(createCustomerDTO);
        return response;
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") String id) throws StripeException {
        Customer response = customerService.getCustomers(id);
        return response;
    }

    @PostMapping("/{id}")
    public Customer updateCustomer(@PathVariable("id") String id, @RequestBody UpdateCustomerDTO request) throws StripeException {
        Customer response = customerService.updateCustomer(id, request);
        return response;
    }

    @DeleteMapping("/{id}")
    public Customer deleteCustomer(@PathVariable("id") String id) throws StripeException {
        Customer response = customerService.deleteCustomer(id);
        return response;
    }

    @GetMapping("/")
    public CustomerCollection getAllCustomers(@RequestParam("limit") Integer limit) throws StripeException {
        CustomerCollection response = customerService.getAllCustomers(limit);
        return response;
    }


    @GetMapping("/search")
    public CustomerSearchResult searchCustomers() throws StripeException {
        CustomerSearchResult response = customerService.searchCustomers();
        return response;
    }




}
