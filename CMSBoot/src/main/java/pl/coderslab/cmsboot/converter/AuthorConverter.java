package pl.coderslab.cmsboot.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.cmsboot.dao.AuthorDao;
import pl.coderslab.cmsboot.entity.Author;

public class AuthorConverter implements Converter<String, Author> {
    @Autowired
    AuthorDao authorDao;

    @Override
    public Author convert(String s) {

        return authorDao.findById(Long.parseLong(s));
    }
}