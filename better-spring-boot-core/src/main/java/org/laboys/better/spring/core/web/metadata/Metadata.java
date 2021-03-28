package org.laboys.better.spring.core.web.metadata;

import java.util.Map;

public interface Metadata {

    /**
     * 注入数据
     */
    void inject(Map<String, Object> data);

}
