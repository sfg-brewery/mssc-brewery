package com.werner.msscbrewery.services;

import com.werner.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .name("Werner")
                .build();
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .name(customerDto.getName())
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(String customerId, CustomerDto customerDto) {
        // Implement
    }

    @Override
    public void deleteCustomer(String customerId) {
        log.debug("Deleting customer with id", customerId);
    }
}
