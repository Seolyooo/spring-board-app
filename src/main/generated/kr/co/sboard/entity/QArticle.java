package kr.co.sboard.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QArticle is a Querydsl query type for Article
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QArticle extends EntityPathBase<Article> {

    private static final long serialVersionUID = 1310254443L;

    public static final QArticle article = new QArticle("article");

    public final NumberPath<Integer> ano = createNumber("ano", Integer.class);

    public final StringPath cate = createString("cate");

    public final NumberPath<Integer> comment_cnt = createNumber("comment_cnt", Integer.class);

    public final StringPath content = createString("content");

    public final NumberPath<Integer> file_cnt = createNumber("file_cnt", Integer.class);

    public final NumberPath<Integer> hit_cnt = createNumber("hit_cnt", Integer.class);

    public final StringPath reg_ip = createString("reg_ip");

    public final StringPath title = createString("title");

    public final DateTimePath<java.time.LocalDateTime> wdate = createDateTime("wdate", java.time.LocalDateTime.class);

    public final StringPath writer = createString("writer");

    public QArticle(String variable) {
        super(Article.class, forVariable(variable));
    }

    public QArticle(Path<? extends Article> path) {
        super(path.getType(), path.getMetadata());
    }

    public QArticle(PathMetadata metadata) {
        super(Article.class, metadata);
    }

}

