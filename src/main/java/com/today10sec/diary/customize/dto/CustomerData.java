package com.today10sec.diary.customize.dto;

import com.today10sec.diary.customize.validator.Sequences;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Getter
@Setter
public class CustomerData implements Serializable {

    private static final long serialVersionUID = 10002L;

    @NotEmpty(groups = Sequences.Order1.class)
    @Length(max=320, groups= Sequences.Order2.class)
    @Email(groups= Sequences.Order2.class)
    private String email;

    @NotEmpty(groups= Sequences.Order3.class)
    @Length(min= 6, max= 12, groups= Sequences.Order4.class)
    @Pattern(regexp="[a-zA-Z1-9]{6,12}",groups= Sequences.Order4.class)
    private String password;

    public CustomerData(@NotEmpty(groups = Sequences.Order1.class) @Length(max = 320, groups = Sequences.Order2.class) @Email(groups = Sequences.Order2.class) String email) {
        this.email = email;
    }

    public CustomerData(@NotEmpty(groups = Sequences.Order1.class) @Length(max = 320, groups = Sequences.Order2.class) @Email(groups = Sequences.Order2.class) String email, @NotEmpty(groups = Sequences.Order3.class) @Length(min = 6, max = 12, groups = Sequences.Order4.class) @Pattern(regexp = "[a-zA-Z1-9]{6,12}", groups = Sequences.Order4.class) String password) {
        this.email = email;
        this.password = password;
    }
}
