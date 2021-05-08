package com.today10sec.diary.mvc.service.impl;

import com.today10sec.diary.customize.dto.CustomerSignUpData;
import com.today10sec.diary.mvc.repository.CustomerRepository;
import com.today10sec.diary.mvc.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class DefaultCustomerService implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
    public CustomerSignUpData addUser(CustomerSignUpData user) {
        return null;
    }

    @Override
    public CustomerSignUpData updateUser(CustomerSignUpData user) {
        return null;
    }

    @Override
    public void delete(String email, String password) {

    }

/*    public CustomerAddData addUser(CustomerAddData user){
        Customer customer = customerRepository.save(new Customer(user.getEmail(),user.getPassword(),user.getName()));
        return new CustomerAddData(customer.getEmail(), customer.getPassword(), customer.getName());
    }

    public CustomerAddData updateUser(CustomerAddData user){
        Customer customer = customerRepository.save(new Customer(user.getEmail(),user.getPassword(),user.getName()));
        return new CustomerAddData(customer.getEmail(), customer.getPassword(), customer.getName());
    }

    public void delete(String email, String password) {
        customerRepository.delete(new Customer(email,password, ""));
    }

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }*/
}

