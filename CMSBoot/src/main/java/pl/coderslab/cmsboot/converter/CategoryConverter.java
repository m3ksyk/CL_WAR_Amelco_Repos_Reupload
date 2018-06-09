package pl.coderslab.cmsboot.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.cmsboot.dao.CategoryDao;
import pl.coderslab.cmsboot.entity.Category;

public class CategoryConverter implements Converter<String, Category> {
    @Autowired
    CategoryDao categoryDao;

    @Override
    public Category convert(String s) {

        return categoryDao.findById(Long.parseLong(s));
    }
}
