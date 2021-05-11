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
    public Customer convert(CustomerData customerData) {

        assertNotNull(customerData,"Object can not be null!!");
        Customer customer= new Customer();

        if (customerData instanceof CustomerSignUpData){
            customer.setPassword(customerData.getPassword());
            customer.setAuth(customer.getAuth());
            customer.setCreatedAt(new Date());
            customer.setEnabled(true);
            customer.setCredentialsNonExpired(false);
            customer.setAccountNonLocked(true);
            customer.setAccountNonExpired(true);

        }

        customer.setEmail(customerData.getEmail());

        return customer;
    }
}
