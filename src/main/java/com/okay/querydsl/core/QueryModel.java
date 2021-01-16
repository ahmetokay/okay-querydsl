package com.okay.querydsl.core;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class QueryModel implements Serializable {

    private List<GenericQueryModel> criteriaQueryModelList;

    private PageModel pageModel;

}