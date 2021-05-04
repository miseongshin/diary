package com.today10sec.diary.service;

import com.today10sec.diary.data.UserAddData;

public interface CustomerService {

    UserAddData addUser(UserAddData user);

    UserAddData updateUser(UserAddData user);

    void delete(String email, String password);

}

