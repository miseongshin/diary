package com.today10sec.diary.customize.Converter;

import com.today10sec.diary.customize.dto.CustomerData;
import com.today10sec.diary.customize.dto.CustomerSignUpData;
import com.today10sec.diary.customize.model.Customer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Date;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@Component
public class CustomerConverter implements Converter<CustomerData, Customer> {
    @Nullable
    @Override
    public Customer convert(CustomerData CustomerData) {

        assertNotNull(CustomerData,"Object can not be null!!");
        Customer customer= new Customer();

        if (CustomerData instanceof CustomerSignUpData){
            customer.setPassword(CustomerData.getPassword());
            customer.setCreatedAt(new Date());
        }

        customer.setEmail(CustomerData.getEmail());

        return customer;
    }
}
