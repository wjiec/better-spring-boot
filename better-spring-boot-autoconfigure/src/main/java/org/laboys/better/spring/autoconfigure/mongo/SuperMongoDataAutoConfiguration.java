package org.laboys.better.spring.autoconfigure.mongo;

import lombok.AllArgsConstructor;
import org.laboys.better.spring.core.convert.EnumToStringConvertFactory;
import org.laboys.better.spring.core.convert.LongToMoneyConverter;
import org.laboys.better.spring.core.convert.MoneyToLongConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.List;

@Configuration
@AllArgsConstructor
class SuperMongoDataAutoConfiguration {

    private final MongoProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public MongoCustomConversions mongoCustomConversions(List<MongoConverterCustomizer> customizers) {
        return MongoCustomConversions.create(config -> {
            for (var customizer : customizers) {
                customizer.customize(config);
            }
        });
    }

    @Bean
    public MongoConverterCustomizer mongoConverterCustomizer() {
        return config -> {
            if (properties.getMoneyConverterSupport()) {
                config.registerConverter(new MoneyToLongConverter());
                config.registerConverter(new LongToMoneyConverter());
            }

            if (properties.getEnumConverterSupport() != MongoProperties.EnumToStringSupport.UNSUPPORTED) {
                config.registerConverterFactory(EnumToStringConvertFactory.builder()
                    .toLowerCaseString(properties.getEnumConverterSupport() == MongoProperties.EnumToStringSupport.LOWER)
                    .toUpperCaseString(properties.getEnumConverterSupport() == MongoProperties.EnumToStringSupport.UPPER)
                    .build());
            }
        };
    }

}
