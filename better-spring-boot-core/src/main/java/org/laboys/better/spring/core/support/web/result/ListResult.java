package org.laboys.better.spring.core.support.web.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Data
@Builder
@ApiModel(description = "列表数据通用包装")
public class ListResult<T> implements Serializable {
    private static final long serialVersionUID = -448428410426418116L;

    /**
     * 列表数据
     */
    @ApiModelProperty("列表数据")
    List<T> result;

    /**
     * 分页数据
     */
    @ApiModelProperty("分页数据")
    Pagination page;

    /**
     * 分页数据结构
     */
    @Data
    @Builder
    @ApiModel(description = "分页数据")
    public static class Pagination implements Serializable {
        private static final long serialVersionUID = -2476576103612166247L;

        /**
         * 分页总数
         */
        @ApiModelProperty("数据总数")
        private long count;

        /**
         * 是否还有下一页
         */
        @ApiModelProperty("是否还有下一页")
        private boolean more;
    }

    /**
     * 构造数据
     */
    public static <T> ListResult<T> of(List<T> data, int count, boolean more) {
        return ListResult.<T>builder()
            .result(data)
            .page(Pagination.builder()
                .count(count)
                .more(more)
                .build())
            .build();
    }

    /**
     * 占位使用的构造方法
     */
    public static <T> ListResult<T> TODO() {
        return ListResult.<T>builder()
            .result(Collections.emptyList())
            .page(Pagination.builder().build())
            .build();
    }

}

