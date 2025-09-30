package kr.co.sboard.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1110028150L;

    public static final QUser user = new QUser("user");

    public final StringPath addr1 = createString("addr1");

    public final StringPath addr2 = createString("addr2");

    public final StringPath email = createString("email");

    public final StringPath hp = createString("hp");

    public final DateTimePath<java.time.LocalDateTime> leave_date = createDateTime("leave_date", java.time.LocalDateTime.class);

    public final StringPath nick = createString("nick");

    public final StringPath pass = createString("pass");

    public final DateTimePath<java.time.LocalDateTime> reg_date = createDateTime("reg_date", java.time.LocalDateTime.class);

    public final StringPath reg_ip = createString("reg_ip");

    public final StringPath us_name = createString("us_name");

    public final StringPath us_role = createString("us_role");

    public final StringPath usid = createString("usid");

    public final StringPath zip = createString("zip");

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

