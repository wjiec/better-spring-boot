package org.laboys.better.spring.core.mongo;

import com.querydsl.core.annotations.QuerySupertype;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@QuerySupertype
public abstract class MongoDocument implements Serializable {
    private static final long serialVersionUID = 1495384929060001022L;

    /**
     * 主键Id
     */
    @Id
    private String id;

    /**
     * 创建时间
     */
    @CreatedDate
    @Field("created_at")
    private LocalDateTime createdAt;

    /**
     * 记录更新时间
     */
    @LastModifiedDate
    @Field("updated_at")
    private LocalDateTime updatedAt;

    /**
     * 记录更新乐观锁
     */
    @Version
    @Field("_version")
    private Long _version;

}
