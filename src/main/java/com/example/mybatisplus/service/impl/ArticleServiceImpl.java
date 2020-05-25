package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.Update;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.entity.Article;
import com.example.mybatisplus.mapper.ArticleMapper;
import com.example.mybatisplus.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplus.vo.PageResult;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.util.resources.cldr.gl.LocaleNames_gl;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

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
        queryWrapper.select(Article::getAuthor,Article::getCode).eq(Article::getId,id);
        return articleMapper.selectOne(queryWrapper);
    }

    @Override
    public List<Article> searchMore(String keywords) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getCatId,10);
        queryWrapper.and(x->x.like(Article::getKeywords,keywords).or().like(Article::getTitle,keywords));
        queryWrapper.select(Article::getAuthor,Article::getCode,Article::getChildTitle,Article::getTitle);
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

    /**
     * update更新字段为null方法测试
     * @param id
     * @return
     */
    @Override
    public boolean updateArticleById(Integer id) {
        Article article = Optional.ofNullable(articleMapper.selectById(id)).orElseThrow(RuntimeException::new);
        LambdaUpdateWrapper<Article> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(Article::getOfflineTime,null);
        updateWrapper.set(Article::getContent,"try mybatis plus update null");
        updateWrapper.set(Article::getPublishTime,LocalDateTime.now().plusHours(8));
        updateWrapper.eq(Article::getId,article.getId());
//        article.setContent("try mybatis plus update null again");
//        article.setPublishTime(LocalDateTime.now().plusHours(8));
//        article.setOfflineTime(null);
        int i = articleMapper.update(article, updateWrapper);
//        int i = articleMapper.updateById(article);
        return i==1;
    }

    @Override
    public List<Article> searchByCondition() {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //1.大于等于
        //queryWrapper.ge(Article::getVisits,100);
        //2.in
//        Long[] catId = {10L,20L};
//        List<Long> catList = Arrays.asList(catId);
//        queryWrapper.in(Article::getCatId,catList);
        //3.between
        //queryWrapper.between(Article::getPublishTime, LocalDate.of(2020,5,1),LocalDate.now().plusMonths(1));
        queryWrapper.eq(Article::getCatId,20);
        //查询指定字段
        queryWrapper.select(Article::getAuthor,Article::getCode,Article::getTitle,Article::getVisits,Article::getCreateTime);
        //按访问量和创建时间排序
        queryWrapper.orderByDesc(Article::getVisits).orderByAsc(Article::getCreateTime);
        return articleMapper.selectList(queryWrapper);
    }
}
