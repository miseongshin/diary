package com.today10sec.diary.mvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.today10sec.diary.customize.dto.CustomerSignUpData;
import com.today10sec.diary.customize.dto.ValidErrorResultData;
import com.today10sec.diary.customize.validator.SameValue;
import com.today10sec.diary.customize.validator.SameValueValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest({CustomerController.class, SameValueValidator.class, SameValue.class, CustomerSignUpData.class})
class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void SIGN_UP_AJAX_VALID_CONFIRM_PW() throws Exception {

        String expectedResult = "{\"validData\":true,\"errors\":[{\"locale\":null,\"fieldName\":\"confirmPassword\",\"message\":\"비밀번호와 비밀번호확인값이 일치하지 않습니다. \"}]}";
        CustomerSignUpData customerSignUpData = new CustomerSignUpData("a@a.com","111111","222222" );
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(customerSignUpData);

        MvcResult mvcResult= mockMvc.perform(
                post("/customer/signUp/ajax")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        String result = mvcResult.getResponse().getContentAsString();
        Gson gson = new Gson();
        ValidErrorResultData resultData = gson.fromJson(result, ValidErrorResultData.class);
        Assertions.assertEquals("confirmPassword",resultData.getErrors().get(0).getFieldName(),"confirmPassword not contian");

    }

}