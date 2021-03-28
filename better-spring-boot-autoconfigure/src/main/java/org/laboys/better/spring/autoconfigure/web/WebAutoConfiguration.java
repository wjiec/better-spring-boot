package org.laboys.better.spring.autoconfigure.web;

import org.laboys.better.spring.core.web.RestExceptionAdvice;
import org.laboys.better.spring.core.web.RestResultAdvice;
import org.laboys.better.spring.core.web.metadata.Metadata;
import org.laboys.better.spring.core.web.metadata.RequestCost;
import org.laboys.better.spring.core.web.metadata.RequestId;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@ConditionalOnWebApplication
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(WebProperties.class)
@Import({WebExceptionAutoConfiguration.class, WebMvcAutoConfiguration.class})
public class WebAutoConfiguration {

    @Configuration
    @ConditionalOnProperty(prefix = WebProperties.PREFIX, name = "decoration.enabled", havingValue = "true", matchIfMissing = true)
    public static class DecorationConfiguration {
        @Bean
        @ConditionalOnProperty(prefix = WebProperties.PREFIX, name = "decoration.on-success", havingValue = "true", matchIfMissing = true)
        public RestResultAdvice restResultAdvice(ApplicationContext context, List<Metadata> metadata) {
            return new RestResultAdvice(context, metadata);
        }

        @Bean
        @ConditionalOnProperty(prefix = WebProperties.PREFIX, name = "decoration.on-failure", havingValue = "true", matchIfMissing = true)
        public RestExceptionAdvice restExceptionAdvice(ApplicationContext context, List<Metadata> metadata) {
            return new RestExceptionAdvice(context, metadata);
        }

        @Bean
        @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.INTERFACES)
        public RequestId requestId() {
            return new RequestId();
        }

        @Bean
        @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.INTERFACES)
        public RequestCost requestCost() {
            return new RequestCost();
        }
    }

}
