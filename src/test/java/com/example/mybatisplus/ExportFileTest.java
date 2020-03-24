package com.example.mybatisplus;

import com.example.mybatisplus.entity.Article;
import com.example.mybatisplus.entity.Country;
import com.example.mybatisplus.export.ExportFile;
import com.example.mybatisplus.export.writemodels.ArticleWriteModel;
import com.example.mybatisplus.export.writemodels.CountryWriteModel;
import com.example.mybatisplus.service.IArticleService;
import com.example.mybatisplus.service.ICountryService;
import com.example.mybatisplus.util.LocalDateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description : 导出Excel测试类
 * @Author : huzhiting
 * @Date: 2020-03-24 16:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExportFileTest {

    @Resource
    ExportFile exportFile;

    @Resource
    IArticleService articleService;

    @Resource
    ICountryService countryService;

    @Test
    public void testExportArticle() throws Exception {
        List<Article> articleList = articleService.list();
        List<ArticleWriteModel> records = new ArrayList<>();
        if(!CollectionUtils.isEmpty(articleList)){
            articleList.forEach(x -> {
                ArticleWriteModel articleWriteModel = new ArticleWriteModel();
                BeanUtils.copyProperties(x,articleWriteModel);
                articleWriteModel.setPublishTime(LocalDateUtil.formatDate(x.getPublishTime(),"yyyy-MM-dd HH:mm:ss"));
                records.add(articleWriteModel);
            });
        }
        String now = LocalDateUtil.formatDate(LocalDateTime.now(),"yyyyMMddHHmmssSSS");
        String pathName = "F:\\excel\\" + "article" + now + ".xlsx";
        exportFile.writeExcel(pathName,records,ArticleWriteModel.class);
    }

    @Test
    public void testExportCountry() throws Exception {
        List<Country> countryList = countryService.list();
        List<CountryWriteModel> writeModels = new ArrayList<>();
        if(!CollectionUtils.isEmpty(countryList)){
            countryList.forEach(x->{
                CountryWriteModel countryWriteModel = new CountryWriteModel();
                BeanUtils.copyProperties(x,countryWriteModel);
                writeModels.add(countryWriteModel);
            });
        }
        String now = LocalDateUtil.formatDate(LocalDateTime.now(),"yyyyMMddHHmmssSSS");
        String pathName = "F:\\excel\\" + "country" + now + ".xlsx";
        exportFile.writeExcel(pathName,writeModels,CountryWriteModel.class);
    }
}
