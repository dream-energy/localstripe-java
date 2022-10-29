package com.project.localstripe.controller;

import com.project.localstripe.request.CreateCustomerDTO;
import com.project.localstripe.request.UpdateCustomerDTO;
import com.project.localstripe.service.CustomerService;
import com.project.localstripe.service.impl.CustomerServiceImpl;
import com.stripe.exception.StripeException;
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
    public String createCustomer(@RequestBody CreateCustomerDTO createCustomerDTO){
        String response = customerService.CreateCustomer(createCustomerDTO);
        return response;
    }

    @GetMapping("/{id}")
    public String getCustomer(@PathVariable("id") String id){
        String response = customerService.getCustomers(id);
        return response;
    }

    @PostMapping("/{id}")
    public String updateCustomer(@PathVariable("id") String id, @RequestBody UpdateCustomerDTO request){
        String response = customerService.updateCustomer(id, request);
        return response;
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable("id") String id){
        String response = customerService.deleteCustomer(id);
        return response;
    }

    @GetMapping("/")
    public String getAllCustomers(){
        String response = customerService.getAllCustomers();
        return response;
    }


    @GetMapping("/search")
    public String searchCustomers(@RequestParam("query") String query) throws StripeException {
        String response = customerService.searchCustomers(query);
        return response;
    }




}
