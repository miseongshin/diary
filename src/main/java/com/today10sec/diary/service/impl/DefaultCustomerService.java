package com.today10sec.diary.service.impl;

import com.today10sec.diary.data.UserAddData;
import com.today10sec.diary.model.Customer;
import com.today10sec.diary.repository.CustomerRepository;
import com.today10sec.diary.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultCustomerService implements CustomerService {

    private CustomerRepository customerRepository;

    public UserAddData addUser(UserAddData user){
        Customer customer = customerRepository.save(new Customer(user.getEmail(),user.getPassword(),user.getName()));
        return new UserAddData(customer.getEmail(), customer.getPassword(), customer.getName());
    }

    public UserAddData updateUser(UserAddData user){
        Customer customer = customerRepository.save(new Customer(user.getEmail(),user.getPassword(),user.getName()));
        return new UserAddData(customer.getEmail(), customer.getPassword(), customer.getName());
    }

    public void delete(String email, String password) {
        customerRepository.delete(new Customer(email,password, ""));
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}

