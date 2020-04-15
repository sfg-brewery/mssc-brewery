package com.werner.msscbrewery.web.controller;

import com.werner.msscbrewery.services.CustomerService;
import com.werner.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId) {
        return new ResponseEntity<CustomerDto>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto savedCustomer = customerService.createCustomer(customerDto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedCustomer.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{customerId}")
    ResponseEntity update(@PathVariable String customerId, CustomerDto customerDto) {
        customerService.updateCustomer(customerId, customerDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable String customerId) {
        customerService.deleteCustomer(customerId);
    }
}
