package com.today10sec.diary.customize.dto;

import com.today10sec.diary.customize.validator.SameValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@AllArgsConstructor
@ToString(exclude = {"password"})
@SameValue(field = "password", fieldMatch = "confirmPassword")
public class CustomerSignUpData {

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Length(min= 6, max = 10)
    private String password;

    @NotEmpty
    private String confirmPassword;

}
