package org.laboys.better.spring.core.convert;

import org.joda.money.Money;
import org.laboys.better.spring.core.util.MoneyUtil;
import org.springframework.core.convert.converter.Converter;

public class LongToMoneyConverter implements Converter<Long, Money> {

    @Override
    public Money convert(Long source) {
        return MoneyUtil.ofMinor(source);
    }

}
