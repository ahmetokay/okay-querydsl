package com.okay.querydsl.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SearchCriteria implements Serializable {

    private String key;

    private String operation;

    private String value;
}