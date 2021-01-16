package com.okay.querydsl.core;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class QueryModel implements Serializable {

    private PageModel pageModel;

    private List<GenericQueryModel> queryModelList;
}