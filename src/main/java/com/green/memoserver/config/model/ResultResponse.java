package com.green.memoserver.config.model;


import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
//@Builder
public class ResultResponse<T> {
    private String resultMessage;
    private T resultData;
}
