package com.project.localstripe.service;

import com.project.localstripe.request.CreateCustomerDTO;
import com.project.localstripe.request.UpdateCustomerDTO;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.CustomerCollection;
import com.stripe.model.CustomerSearchResult;
import com.stripe.param.CustomerSearchParams;

public interface CustomerService {
    public Customer CreateCustomer(CreateCustomerDTO customerRequestDTO) throws StripeException;


    public Customer getCustomers(String id) throws StripeException;

    public Customer updateCustomer(String id, UpdateCustomerDTO updateCustomerDTO) throws StripeException;

    public Customer deleteCustomer(String id) throws StripeException;

    public CustomerCollection getAllCustomers(Integer limit) throws StripeException;

    public CustomerSearchResult searchCustomers() throws StripeException;
}
