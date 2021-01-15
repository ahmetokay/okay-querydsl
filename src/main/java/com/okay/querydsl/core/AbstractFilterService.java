package com.okay.querydsl.core;

import com.okay.querydsl.entity.Role;
import com.okay.querydsl.model.SearchCriteria;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.ListPath;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractFilterService<FM extends FilterModel, E extends BaseEntity> {

    protected BooleanBuilder booleanBuilder;

    private Class<E> entityClass;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    public AbstractFilterService() {
        this.entityClass = (Class<E>) (((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
    }

    public List<E> filter(FM filterModel) {
        booleanBuilder = new BooleanBuilder();

        JPAQueryFactory query = new JPAQueryFactory(entityManager);
        PathBuilder<E> entityPath = new PathBuilder<E>(entityClass, "entity");


        List<SearchCriteria> criteriaList = filterModel.getCriteriaList();
        for (SearchCriteria searchCriteria : criteriaList) {
            Class<?> type = entityPath.get(searchCriteria.getKey()).getType();
            // TODO Class tipi alınarak oradan path getirilip sorgu yazılması, condition yazılması
            StringPath username = entityPath.getString(searchCriteria.getKey());

//            Path path = entityPath.getString(searchCriteria.getKey());
//            switch (searchCriteria.getOperation()) {
//                case ":":
//                    return path.eq(value);
//                case ">":
//                    return path.goe(value);
//                case "<":
//                    return path.loe(value);
//            }

//            BooleanExpression usernameLike = username.likeIgnoreCase("%" + searchCriteria.getValue() + "%");
//            booleanBuilder.and(usernameLike);
        }

        Role role = new Role();
        role.setId(1);

        ListPath<Role, PathBuilder<Role>> roleList = entityPath.getList("roleList", Role.class);
        BooleanExpression roleExpression = roleList.contains(role);
        booleanBuilder.and(roleExpression);

        StringPath username = entityPath.getString("username");
        BooleanExpression usernameLike = username.likeIgnoreCase("%HME%");
        booleanBuilder.and(usernameLike);

        return query.selectFrom(entityPath).where(booleanBuilder).fetchResults().getResults();
    }
}
