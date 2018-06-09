package pl.coderslab.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.coderslab.converter.AuthorConverter;
import pl.coderslab.converter.ArticleConverter;
import pl.coderslab.converter.CategoryConverter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.coderslab")
@EnableTransactionManagement
public class FormatterConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addFormatters(FormatterRegistry registry) {

        registry.addConverter(authorConverter());
        registry.addConverter(articleConverter());
        registry.addConverter(categoryConverter());
    }

    @Bean
    public AuthorConverter authorConverter(){

        return new AuthorConverter();
    }

    @Bean
    public ArticleConverter articleConverter(){
        return new ArticleConverter();
    }

    @Bean
    public CategoryConverter categoryConverter(){
        return new CategoryConverter();
    }

}
