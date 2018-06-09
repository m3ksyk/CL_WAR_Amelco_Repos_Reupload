package pl.coderslab.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.coderslab.converter.AuthorConverter;
import pl.coderslab.converter.BookConverter;
import pl.coderslab.converter.PublisherConverter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.coderslab")
@EnableTransactionManagement
public class FormatterConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(authorConverter());
        registry.addConverter(bookConverter());
        registry.addConverter(publisherConverter());
    }

    @Bean
    public AuthorConverter authorConverter(){
        return new AuthorConverter();
    }

    @Bean
    public BookConverter bookConverter(){
        return new BookConverter();
    }

    @Bean
    public PublisherConverter publisherConverter(){
        return new PublisherConverter();
    }

}
