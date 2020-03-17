package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.entity.Article;
import com.example.mybatisplus.mapper.ArticleMapper;
import com.example.mybatisplus.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplus.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author huzhiting
 * @since 2019-06-03
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    @Resource
    ArticleMapper articleMapper;

    @Override
    public List<Article> searchByCatId(Integer catId) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Article::getCatId,catId);
        List<Article> articles = articleMapper.selectList(queryWrapper);
        articles.forEach(x-> System.out.println("文章栏目编号：" + x.getCatId() + ",文章标题：" + x.getTitle()));
        return articles;
    }

    @Override
    public Article searchOne(Integer id) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getId,id);
        Article article = articleMapper.selectOne(queryWrapper);
        return article;
    }

    @Override
    public List<Article> searchMore(String keywords) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Article::getKeywords,keywords);
        List<Article> articles = articleMapper.selectList(queryWrapper);
        articles.forEach(x-> System.out.println("文章关键字：" + x.getKeywords() + ",文章标题：" + x.getTitle()));
        return articles;
    }

    @Override
    public List<Article> searchMoreByMap(String code) {
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("code",code);
        List<Article> articles = articleMapper.selectByMap(queryMap);
        articles.forEach(x-> System.out.println("文章编码：" + x.getCatId() + ",文章标题：" + x.getTitle()));
        return articles;
    }

    @Override
    public PageResult<Article> searchArticlePage(Integer page, Integer size) {
        IPage<Article> articleIPage = new Page<>(page,size);
        QueryWrapper<Article> articleQueryWrapper = new QueryWrapper<>();
        articleQueryWrapper.lambda().eq(Article::getIsDeleted,0);
        IPage<Article> iPage = articleMapper.selectPage(articleIPage, articleQueryWrapper);
        PageResult<Article> pageResult = new PageResult<>();
        pageResult.setItems(iPage.getRecords());
        pageResult.setTotal(iPage.getTotal());
        System.out.println("文章总数：" + pageResult.getTotal());
        return pageResult;
    }
}
