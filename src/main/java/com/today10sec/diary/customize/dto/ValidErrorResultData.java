package com.today10sec.diary.customize.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ValidErrorResultData {
    private final Boolean validData = true;
    private List<ValidErrorData> errors;
}
