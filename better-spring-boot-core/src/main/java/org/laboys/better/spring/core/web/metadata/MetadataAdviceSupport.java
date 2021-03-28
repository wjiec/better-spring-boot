package org.laboys.better.spring.core.web.metadata;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public abstract class MetadataAdviceSupport {

    /**
     * 请求元数据列表
     */
    private final List<Metadata> metadata;

    /**
     * 生成最终数据
     */
    protected Map<String, Object> buildExtra() {
        Map<String, Object> data = new HashMap<>();
        for (var item : metadata) {
            item.inject(data);
        }

        return data;
    }

}
