package com.example.mybatisplus.controller;


import com.example.mybatisplus.entity.Article;
import com.example.mybatisplus.service.IArticleService;
import com.example.mybatisplus.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 文章表 前端控制器
 * </p>
 *
 * @author huzhiting
 * @since 2019-06-03
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    IArticleService iArticleService;

    /**
     * 获取某一栏目编号下所有文章
     * @param catId
     * @return
     */
    @ResponseBody
    @RequestMapping("/search/{catId}")
    public List<Article> searchBySiteId(@PathVariable Integer catId){
        List<Article> articles = iArticleService.searchByCatId(catId);
        return articles;
    }

    /**
     * 获取某一篇文章，确定查询结果只有一个的情况可以使用
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/search/one/{id}")
    public Article searchOne(@PathVariable Integer id){
        Article article = iArticleService.searchOne(id);
        return article;
    }

    /**
     * 按关键字搜索模糊文章
     * @param keywords
     * @return
     */
    @ResponseBody
    @RequestMapping("/search/more/{keywords}")
    public List<Article> searchMore(@PathVariable String keywords){
        List<Article> articles = iArticleService.searchMore(keywords);
        return articles;
    }

    /**
     * 按文章编码精确查询，用Map查询
     * @param code
     * @return
     */
    @ResponseBody
    @RequestMapping("/searchByMap/more/{code}")
    public List<Article> searchMoreByMap(@PathVariable String code){
        List<Article> articles = iArticleService.searchMoreByMap(code);
        return articles;
    }

    /**
     * 查询所有文章 - 分页
     * @param page
     * @param size
     * @return
     */
    @ResponseBody
    @RequestMapping("/search/{page}/{size}")
    public PageResult<Article> searchArticlePage(@PathVariable Integer page, @PathVariable Integer size){
        PageResult<Article> articles = iArticleService.searchArticlePage(page,size);
        return articles;
    }


    @ResponseBody
    @RequestMapping("/update/{id}")
    public boolean updateArticleById(@PathVariable Integer id){
        return iArticleService.updateArticleById(id);
    }
}
