package com.werner.msscbrewery.services;

import com.werner.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);

    CustomerDto createCustomer(CustomerDto customerDto);

    void updateCustomer(String customerId, CustomerDto customerDto);

    void deleteCustomer(String customerId);
}
