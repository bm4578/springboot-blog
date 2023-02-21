package xyz.onlytype.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.onlytype.config.utils.ResultModel;
import xyz.onlytype.service.SysArticleService;

/**
 * @author 白也
 * @title
 * @date 2023/2/20 11:52 下午
 */
@Api(value = "/api/article/", tags = {"文章管理"})
@RestController
@RequestMapping("/api/article/")
public class ArticleController {
    @Autowired
    private SysArticleService articleService;

    /**
     * 分页查询文章
     * @param pageNum 页面
     * @param pageSize 页数
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "int", name = "pageNum", value = "页数", required = true),
            @ApiImplicitParam(paramType = "path", dataType = "int", name = "pageSize", value = "大小", required = true),
    })
    @ApiOperation(value = "分页查询文章", notes = "分页查询文章", httpMethod = "GET")
    @GetMapping("all/{pageNum}/{pageSize}")
    public ResultModel selectArticle(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return ResultModel.ok(articleService.pageList(pageNum, pageSize));
    }
}
