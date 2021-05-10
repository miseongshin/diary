package com.today10sec.diary.mvc.service.impl;

import com.today10sec.diary.customize.dto.CustomerSignUpData;
import com.today10sec.diary.customize.model.Customer;
import com.today10sec.diary.mvc.repository.CustomerRepository;
import com.today10sec.diary.mvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@Service
public class DefaultCustomerService implements CustomerService {

    protected CustomerRepository customerRepository;

    @Override
    public boolean saveCustomer(Customer customer) {

        assertNotNull(customer,"customerSignUpData can not be null!!");
        assertNotNull(customer.getEmail(),"email can not be null!!");
        customerRepository.save(customer);
        return true;
    }

    @Override
    public CustomerSignUpData updateUser(CustomerSignUpData user) {
        return null;
    }

    @Override
    public void delete(String email, String password) {

    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}

