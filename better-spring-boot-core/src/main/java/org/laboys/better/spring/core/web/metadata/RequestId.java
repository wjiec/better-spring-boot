package org.laboys.better.spring.core.web.metadata;

import cn.hutool.core.util.RandomUtil;

import java.util.Map;

public class RequestId implements Metadata {

    private final String requestId = RandomUtil.randomString(26);

    @Override
    public void inject(Map<String, Object> data) {
        data.put("request-id", requestId);
    }

}
