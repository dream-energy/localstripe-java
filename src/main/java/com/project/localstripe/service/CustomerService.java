package com.project.localstripe.service;

import com.project.localstripe.request.CreateCustomerDTO;
import com.project.localstripe.request.UpdateCustomerDTO;

public interface CustomerService {
    public String CreateCustomer(CreateCustomerDTO customerRequestDTO);


    public String getCustomers(String id);

    public String updateCustomer(String id, UpdateCustomerDTO updateCustomerDTO);

    public String deleteCustomer(String id);

    public String getAllCustomers();

    public String searchCustomers(String query);
}
