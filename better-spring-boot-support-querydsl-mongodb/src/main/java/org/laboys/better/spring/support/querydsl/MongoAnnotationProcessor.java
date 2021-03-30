package org.laboys.better.spring.support.querydsl;

import com.querydsl.apt.AbstractQuerydslProcessor;
import com.querydsl.apt.Configuration;
import com.querydsl.apt.DefaultConfiguration;
import com.querydsl.core.annotations.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.RoundEnvironment;
import java.util.Collections;

/**
 * copy from mongodb-starter and remove logging output.
 *
 * @see org.springframework.data.mongodb.repository.support.MongoAnnotationProcessor
 */
public class MongoAnnotationProcessor extends AbstractQuerydslProcessor {

    @Override
    protected Configuration createConfiguration(RoundEnvironment roundEnv) {
        DefaultConfiguration configuration = new DefaultConfiguration(processingEnv, roundEnv, Collections.emptySet(),
            QueryEntities.class, Document.class, QuerySupertype.class, QueryEmbeddable.class, QueryEmbedded.class,
            QueryTransient.class);
        configuration.setUnknownAsEmbedded(true);

        return configuration;
    }

}
