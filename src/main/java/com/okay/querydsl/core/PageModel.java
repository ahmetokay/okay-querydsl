package com.okay.querydsl.core;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class PageModel implements Serializable {

    @NotNull
    private Integer page;

    @NotNull
    private Integer size;

    @NotNull
    private String sortField;

    @NotNull
    private Integer sortOrder;
}