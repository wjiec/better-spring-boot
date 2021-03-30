package org.laboys.better.spring.core.support.web.search;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "分页查询参数")
public class PageableSupport {

    /**
     * 分页长度
     */
    @Builder.Default
    @ApiModelProperty("分页长度")
    @Max(value = 200, message = "{pagination.size.max}")
    @Min(value = 2, message = "{pagination.size.min}")
    private int size = 20;

    /**
     * 分页页码
     */
    @Builder.Default
    @ApiModelProperty("分页页码")
    @Min(value = 1, message = "{pagination.page.min}")
    private int page = 1;

}
