package com.okay.querydsl.core;

import lombok.Data;

import java.io.Serializable;

@Data
public class GenericQueryModel implements Serializable {

    private String key;

    private String operation;

    private String value;
}