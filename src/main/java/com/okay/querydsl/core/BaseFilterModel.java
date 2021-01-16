package com.okay.querydsl.core;

import com.okay.querydsl.model.SearchCriteria;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class BaseFilterModel implements Serializable {

    @NotNull
    private Integer page = 0;

    private Integer size = 10;

    @NotNull
    private String sortField;

    @NotNull
    private Integer sortOrder;

    private List<SearchCriteria> criteriaList;
}