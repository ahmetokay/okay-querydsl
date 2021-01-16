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

    public PageModel() {
    }

    public PageModel(Integer page, Integer size, String sortField, Integer sortOrder) {
        this.page = page;
        this.size = size;
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
}