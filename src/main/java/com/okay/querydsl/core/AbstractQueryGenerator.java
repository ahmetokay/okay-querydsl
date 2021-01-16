package com.okay.querydsl.core;

import com.okay.querydsl.core.BaseEntity;
import com.okay.querydsl.core.GenericQueryModel;
import com.okay.querydsl.core.QueryModel;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractQueryGenerator<QM extends QueryModel, E extends BaseEntity, EP extends EntityPathBase<E>> {

    private final Class<E> entityClass;

    private final PathBuilder<E> entityPath;

    public AbstractQueryGenerator() {
        this.entityClass = (Class<E>) (((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
        this.entityPath = new PathBuilder<>(entityClass, entityClass.getSimpleName().toLowerCase());
    }

    protected abstract void prepareQuery(BooleanBuilder queryBuilder, QM queryModel, EP entityPath);

    public Predicate generateQuery(QM queryModel, EP entityPath) {
        BooleanBuilder queryBuilder = new BooleanBuilder();
        prepareQuery(queryBuilder, queryModel, entityPath);
        prepareQueryWithFilter(queryBuilder, queryModel);
        prepareQueryWithGenericCriteria(queryBuilder, queryModel.getQueryModelList());
        return queryBuilder;
    }

    protected void prepareQueryWithFilter(BooleanBuilder queryBuilder, QM queryModel) {
        /**/
    }

    protected void prepareQueryWithGenericCriteria(BooleanBuilder queryBuilder, List<GenericQueryModel> genericQueryModelList) {
        for (GenericQueryModel genericQueryModel : genericQueryModelList) {
            StringPath string = entityPath.getString(genericQueryModel.getKey());
            switch (genericQueryModel.getOperation()) {
                case "equal":
                    queryBuilder.and(string.eq(String.valueOf(genericQueryModel.getValue())));
                    break;
                case "like":
                    queryBuilder.and(string.likeIgnoreCase("%" + genericQueryModel.getValue() + "%"));
                    break;
                default:
            }
        }
    }
}