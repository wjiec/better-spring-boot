package org.laboys.better.spring.core.convert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

@Data
@Builder
@AllArgsConstructor
public class EnumToStringConvertFactory implements ConverterFactory<Enum<?>, String> {

    /**
     * 是否转换为小写格式的字符串
     */
    private final boolean toLowerCaseString;

    /**
     * 是否转换为大写格式的字符串
     */
    private final boolean toUpperCaseString;

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public <T extends String> Converter<Enum<?>, T> getConverter(Class<T> targetType) {
        return new EnumToStringConverter();
    }

    /**
     * 枚举类型转换为字符串类型
     */
    private class EnumToStringConverter<T extends Enum<?>> implements Converter<T, String>{
        @Override
        public String convert(T source) {
            if (toLowerCaseString) {
                return source.name().toLowerCase();
            } else if (toUpperCaseString) {
                return source.name().toUpperCase();
            }

            return source.name();
        }
    }

}
