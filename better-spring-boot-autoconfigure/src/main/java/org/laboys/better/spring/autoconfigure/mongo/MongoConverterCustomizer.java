package org.laboys.better.spring.autoconfigure.mongo;

import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

public interface MongoConverterCustomizer {

    void customize(MongoCustomConversions.MongoConverterConfigurationAdapter config);

}
