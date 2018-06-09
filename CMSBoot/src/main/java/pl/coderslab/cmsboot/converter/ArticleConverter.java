package pl.coderslab.cmsboot.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.cmsboot.dao.ArticleDao;
import pl.coderslab.cmsboot.entity.Article;

public class ArticleConverter implements Converter<String, Article> {
    @Autowired
    ArticleDao articleDao;

    @Override
    public Article convert(String s) {

        return articleDao.findById(Long.parseLong(s));
    }
}

