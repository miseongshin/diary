package com.today10sec.diary.mvc.service;

import com.today10sec.diary.customize.dto.CustomerSignUpData;

public interface CustomerService {

    CustomerSignUpData addUser(CustomerSignUpData user);

    CustomerSignUpData updateUser(CustomerSignUpData user);

    void delete(String email, String password);

}

