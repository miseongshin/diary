package com.today10sec.diary.mvc.service;

import com.today10sec.diary.customize.dto.CustomerSignUpData;
import com.today10sec.diary.customize.model.Customer;

public interface CustomerService {

    boolean saveCustomer(Customer user);

    CustomerSignUpData updateUser(CustomerSignUpData user);

    void delete(String email, String password);

}

