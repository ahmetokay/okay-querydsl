package com.okay.querydsl.model;

import com.okay.querydsl.core.PageModel;
import lombok.Data;

import java.io.Serializable;

@Data
public class ReturnData<T extends Object> implements Serializable {

    private PageModel pageModel;

    private T data;
}