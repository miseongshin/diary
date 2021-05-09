package com.today10sec.diary.customize.dto;

import com.today10sec.diary.customize.validator.SameValue;
import com.today10sec.diary.customize.validator.Sequences;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@AllArgsConstructor
@ToString(exclude = {"password", "confirmPassword"})
@SameValue(field = "password", fieldMatch = "confirmPassword", groups= Sequences.Order6.class)
public class CustomerSignUpData {


    @NotEmpty(groups = Sequences.Order1.class)
    @Length(max=320, groups= Sequences.Order2.class)
    @Email(groups= Sequences.Order2.class)
    private String email;

    @NotEmpty(groups= Sequences.Order3.class)
    @Length(min= 6, max= 12, groups= Sequences.Order4.class)
    @Pattern(regexp="[a-zA-Z1-9]{6,12}",groups= Sequences.Order4.class)
    private String password;


    @NotEmpty(groups= Sequences.Order5.class)
    @Length(min= 6, max= 12, groups= Sequences.Order7.class)
    private String confirmPassword;

}
