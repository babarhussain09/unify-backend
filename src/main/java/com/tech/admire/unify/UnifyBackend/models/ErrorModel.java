package com.tech.admire.unify.UnifyBackend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorModel {

    private Integer errorCode;
    private String message;
    private String details;

}
