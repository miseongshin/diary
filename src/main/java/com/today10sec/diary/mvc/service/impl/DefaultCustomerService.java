package com.today10sec.diary.mvc.service.impl;

import com.today10sec.diary.customize.dto.CustomerData;
import com.today10sec.diary.customize.dto.CustomerSignUpData;
import com.today10sec.diary.customize.model.Customer;
import com.today10sec.diary.mvc.repository.CustomerRepository;
import com.today10sec.diary.mvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@Service
public class DefaultCustomerService implements CustomerService {

    protected CustomerRepository customerRepository;
    protected Converter<CustomerData, Customer> converter;

    @Override
    public boolean saveCustomer(CustomerSignUpData customerSignUpData) {

        assertNotNull(customerSignUpData,"customerSignUpData can not be null!!");
        Customer customer = converter.convert(customerSignUpData);
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

    @Autowired
    public void setConverter(Converter<CustomerData, Customer> converter) {
        this.converter = converter;
    }
}

