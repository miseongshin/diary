package com.today10sec.diary.customize.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ResultData {
    private int code;
    private String message;
    private String prevPage;
}
