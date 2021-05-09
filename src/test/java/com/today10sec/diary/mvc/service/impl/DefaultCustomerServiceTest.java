package com.today10sec.diary.mvc.service.impl;

import com.today10sec.diary.customize.dto.CustomerSignUpData;
import com.today10sec.diary.mvc.service.CustomerService;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DefaultCustomerServiceTest {

    @MockBean
    CustomerService customerService;

    @Test
    void save_customer() {
        //given
        CustomerSignUpData customerSignUpData = new CustomerSignUpData("test@test.com","11111", "11111");
        //when
        boolean result = customerService.saveCustomer(customerSignUpData);
        //then
        assertEquals(true,result);;

    }

}