package com.project.localstripe.service.impl;

import com.project.localstripe.request.CreateCustomerDTO;
import com.project.localstripe.request.UpdateCustomerDTO;
import com.project.localstripe.service.CustomerService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.CustomerCollection;
import com.stripe.model.CustomerSearchResult;
import com.stripe.param.CustomerSearchParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import java.util.Map;

@Slf4j
@Service

public class CustomerServiceImpl implements CustomerService {


    @Value("${stripe.api.key}")
    private String API_KEY;

    @Override
    public Customer CreateCustomer(CreateCustomerDTO customerRequestDTO) throws StripeException {
        Stripe.apiKey = API_KEY;
        Map<String, Object> params = new HashMap<>();
        params.put(
                "description",
                customerRequestDTO.getDescription()
        );

        Customer customer = Customer.create(params);

        return customer;
    }

    @Override
    public Customer getCustomers(String id) throws StripeException {
        Stripe.apiKey = API_KEY;
        return Customer.retrieve(id);
    }

    @Override
    public Customer updateCustomer(String id, UpdateCustomerDTO updateCustomerDTO) throws StripeException {
        Stripe.apiKey = API_KEY;
        Customer customer =
                Customer.retrieve("cus_8eqdcH07DUqA5s");

        Map<String, Object> metadata = new HashMap<>();
        metadata.put("order_id", updateCustomerDTO.getOrderId());
        Map<String, Object> params = new HashMap<>();
        params.put("metadata", metadata);

        Customer updatedCustomer =
                customer.update(params);
        return updatedCustomer;
    }

    @Override
    public Customer deleteCustomer(String id) throws StripeException {
        Stripe.apiKey = API_KEY;
        Customer customer =
                Customer.retrieve(id);

        Customer deletedCustomer = customer.delete();
        return deletedCustomer;
    }

    @Override
    public CustomerCollection getAllCustomers(Integer limit) throws StripeException {
        Stripe.apiKey = API_KEY;
        Map<String, Object> params = new HashMap<>();
        params.put("limit", limit);

        CustomerCollection customers =
                Customer.list(params);

        return customers;
    }

    @Override
    public CustomerSearchResult searchCustomers() throws StripeException {
        Stripe.apiKey = API_KEY;
        CustomerSearchParams params =
                CustomerSearchParams
                        .builder()
                        .setQuery("name:'fakename' AND metadata['foo']:'bar'")
                        .build();

        CustomerSearchResult result = Customer.search(params);
        return result;
    }


}
