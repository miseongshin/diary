package com.today10sec.diary.mvc.service.impl;

import com.today10sec.diary.customize.model.Customer;
import com.today10sec.diary.mvc.repository.CustomerRepository;
import com.today10sec.diary.mvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DefaultCustomerService implements CustomerService, UserDetailsService {

    protected CustomerRepository customerRepository;

    @Override
    public Boolean isExistEmail(String email) {
        try{
            loadUserByUsername(email);
            return Boolean.TRUE;
        }catch (UsernameNotFoundException e){

        }
            return Boolean.FALSE;
    }

    @Override
    public Integer save(Customer customer){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encryptedPassword = encoder.encode(customer.getPassword());
        customer.setPassword(encoder.encode(customer.getPassword()));
        return customerRepository.save(customer).getId();
    }

    @Override
    public Customer loadUserByUsername(String email) throws UsernameNotFoundException {
        return customerRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(email));
    }


    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}

