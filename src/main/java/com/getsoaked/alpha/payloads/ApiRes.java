package com.getsoaked.alpha.payloads;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiRes {
    private Boolean success;
    private String message;

    @Builder
    public ApiRes(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}