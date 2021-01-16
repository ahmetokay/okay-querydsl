package com.okay.querydsl.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -338783478L;

    public static final QUser user = new QUser("user");

    public final com.okay.querydsl.core.QBaseEntity _super = new com.okay.querydsl.core.QBaseEntity(this);

    //inherited
    public final NumberPath<Integer> id = _super.id;

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final DateTimePath<java.util.Date> registerDate = createDateTime("registerDate", java.util.Date.class);

    public final ListPath<Role, QRole> roleList = this.<Role, QRole>createList("roleList", Role.class, QRole.class, PathInits.DIRECT2);

    public final StringPath surname = createString("surname");

    public final EnumPath<com.okay.querydsl.enm.EnumUserType> type = createEnum("type", com.okay.querydsl.enm.EnumUserType.class);

    public final StringPath username = createString("username");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

