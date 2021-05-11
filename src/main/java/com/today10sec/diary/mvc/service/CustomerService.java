package com.today10sec.diary.mvc.service;

import com.today10sec.diary.customize.model.Customer;

public interface CustomerService {

    Integer save(Customer customer);

    Customer loadUserByUsername(String email);

    Boolean isExistEmail(String email);
}

