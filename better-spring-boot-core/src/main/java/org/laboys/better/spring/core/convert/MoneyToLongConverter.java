package org.laboys.better.spring.core.convert;

import org.joda.money.Money;
import org.springframework.core.convert.converter.Converter;

public class MoneyToLongConverter implements Converter<Money, Long> {

    @Override
    public Long convert(Money source) {
        return source.getAmountMinorLong();
    }

}
