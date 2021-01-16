package com.okay.querydsl.core;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageModel implements Serializable {

    private Integer page = 0;

    private Integer size = 10;

    private String sortField = "id";

    private Integer sortOrder = 1;
}