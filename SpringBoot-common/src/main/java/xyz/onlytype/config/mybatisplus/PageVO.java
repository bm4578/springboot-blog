package xyz.onlytype.config.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

/**
 * @author 白也
 * @title 返回分页对象
 * @date 2023/2/20 3:50 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVO<T> implements Serializable {
    /**
     * 当前页码
     */
    @ApiModelProperty(value = "当前页码", example = "1")
    protected Long pageIndex;

    /**
     * 每页显示最大数据条数
     */
    @ApiModelProperty(value = "每页显示最大数据条数", example = "10")
    protected Long pageSize;

    /**
     * 数据的总条数
     */
    @ApiModelProperty(value = "总条数", example = "100000")
    protected Long total;

    /**
     * 数据的总页数
     */
    @ApiModelProperty(value = "总页数", example = "100")
    protected Long pages;

    /**
     * 当前页数据列表
     */
    @ApiModelProperty(value = "当前页数据列表")
    protected List<T> rows;

    public static <T> PageVO<T> pageList(Page<T> page) {
        PageVO<T> pageResult = new PageVO<>();
        pageResult.setTotal(page.getTotal());
        pageResult.setRows(page.getRecords());
        pageResult.setPageIndex(page.getCurrent());
        pageResult.setPageSize(page.getSize());
        pageResult.setPages(page.getPages());
        return pageResult;
    }

}
