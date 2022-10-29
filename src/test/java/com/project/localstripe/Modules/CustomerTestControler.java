package com.project.localstripe.Modules;


import com.project.localstripe.controller.CustomerController;
import com.project.localstripe.request.CreateCustomerDTO;
import com.project.localstripe.service.impl.CustomerServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CustomerTestControler {
    @Mock
    private CustomerServiceImpl customerService;

    @InjectMocks
    private CustomerController customerController;

    private static final CreateCustomerDTO CUSTOMER_REQUEST = new CreateCustomerDTO("abc");
    private static final String ID = "cus_8eqdcH07DUqA5s";

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        customerController = new CustomerController(customerService);
    }


    @Test
    public void successScenario(){
        String customer = customerController.createCustomer(CUSTOMER_REQUEST);
        System.out.println("success"+customer);
    }


    @Test
    public void successScenarioWithNullDescription(){

        CUSTOMER_REQUEST.setDescription(null);

        String customer = customerController.createCustomer(CUSTOMER_REQUEST);
        System.out.println("success with Description Null"+customer);
    }



}
