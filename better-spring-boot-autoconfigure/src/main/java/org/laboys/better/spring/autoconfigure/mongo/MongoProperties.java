package org.laboys.better.spring.autoconfigure.mongo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = MongoProperties.PREFIX)
public class MongoProperties {

    /**
     * Mongo配置前缀
     */
    public static final String PREFIX = "better.mongo";

    /**
     * 是否删除默认添加的_class字段映射
     */
    private Boolean removeClassMapping = false;

    /**
     * 是否默认增加Money类型的转换器支持
     */
    private Boolean moneyConverterSupport = true;

    /**
     * 是否自动将枚举类型转换为小写形式
     */
    private EnumToStringSupport enumConverterSupport = EnumToStringSupport.LOWER;

    /**
     * 枚举类型转换
     */
    public enum EnumToStringSupport {
        LOWER, UPPER, UNSUPPORTED
    }

}
