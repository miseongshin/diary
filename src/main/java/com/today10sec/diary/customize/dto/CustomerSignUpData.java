package com.today10sec.diary.customize.dto;

import com.today10sec.diary.customize.validator.SameValue;
import com.today10sec.diary.customize.validator.Sequences;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@ToString(exclude = {"password", "confirmPassword"})
@SameValue(field = "password", fieldMatch = "confirmPassword", groups= Sequences.Order6.class)
public class CustomerSignUpData extends CustomerData{

    public static final long serialVersionUID = 10001L;

    @NotEmpty(groups= Sequences.Order5.class)
    @Length(min= 6, max= 12, groups= Sequences.Order7.class)
    private String confirmPassword;

    public CustomerSignUpData(String email, String password, String confirmPassword, String auth) {
        super(email, password, auth);
        this.confirmPassword = confirmPassword;
    }
}
