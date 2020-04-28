package com.example.mybatisplus.service;

import com.example.mybatisplus.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplus.vo.PageResult;

import java.util.List;

/**
 * <p>
 * 文章表 服务类
 * </p>
 *
 * @author huzhiting
 * @since 2019-06-03
 */
public interface IArticleService extends IService<Article> {

    List<Article> searchByCatId(Integer catId);

    Article searchOne(Integer id);

    List<Article> searchMore(String keywords);

    List<Article> searchMoreByMap(String code);

    PageResult<Article> searchArticlePage(Integer page, Integer size);

    boolean updateArticleById(Integer id);
}
