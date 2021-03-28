package org.laboys.better.spring.core.web.metadata;

import java.util.Map;

public class RequestCost implements Metadata {

    private final long start = System.nanoTime();

    @Override
    public void inject(Map<String, Object> data) {
        data.put("cost", (System.nanoTime() -  start) / 1_000_000_000.0);
    }

}
