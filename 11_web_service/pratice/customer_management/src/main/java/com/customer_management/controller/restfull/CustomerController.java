package com.customer_management.controller.restfull;

import com.customer_management.model.Customer;
import com.customer_management.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public ResponseEntity<Iterable<Customer>> findAllCustomer() {
        List<Customer> customers = (List<Customer>) customerService.findAll();
        if (customers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Optional<Customer> optionalCustomer = customerService.findById(id);
        if(!optionalCustomer.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(optionalCustomer.get().getId());
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.remove(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.NO_CONTENT);
    }
}
