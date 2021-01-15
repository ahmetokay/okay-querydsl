package com.okay.querydsl.core;

import com.okay.querydsl.model.SearchCriteria;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FilterModel implements Serializable {

    private List<SearchCriteria> criteriaList;
}